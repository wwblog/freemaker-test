package com.xcw.freemarker.demo.app.httpclent.xunfei;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.httpclent.BaseClent;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;

/**
 * @Author xcw
 * @Date 2021/3/1 16:05
 * @Description 描述
 */
@Log4j2
@Component
public class XunFeiClient extends BaseClent {

    @Value("${xunfei.base.url}")
    private String url;

    @Value("${xunfei.base.appId}")
    private String appId;

    @Value("${xunfei.base.appKey}")
    private String appKey;

    private WebClient webClient;


    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl(url).filter(logRequest()).build();
    }

    public <T> T operator(final XunFeiRequest request, final Class<T> responseClass) throws UnsupportedEncodingException {


        logRequestBody(request.getBody());


        //当前时间
        String curTime = System.currentTimeMillis() / 1000L + "";
        //当前参数
        String param = new String(Base64.encodeBase64(JSONObject.toJSONString(request.getQuery()).getBytes("UTF-8")));
        //生成令牌
        String checkSum = DigestUtils.md5DigestAsHex((appKey + curTime + param).getBytes());


        //配置请求方式，参数，请求类型
        WebClient.RequestBodySpec requestBodySpec = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        //.queryParams(request.queryParams())
                        .path(request.uri())
                        .build())
                .accept(request.getMediaType())
                .contentType(request.getMediaType())

                .header("X-Appid", appId)
                .header("X-CurTime", curTime)
                .header("X-Param", param)
                .header("X-CheckSum", checkSum);
        if (null != request.getBody()) {
            requestBodySpec.body(BodyInserters.fromFormData(request.bodyParams()));
        }

        //接受响应数据
        ResponseEntity<String> responseEntity = requestBodySpec.retrieve().toEntity(String.class).block();
        logResponseBody(responseEntity.getBody());

        T response;
        response = JSONObject.parseObject(responseEntity.getBody(), responseClass);
        return response;
    }

}
