package com.xcw.freemarker.demo.app.httpclent.unisound;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.httpclent.BaseClent;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * @Author xcw
 * @Date 2021/3/1 16:05
 * @Description 云之声
 */
@Log4j2
@Component
public class UniSoundClient extends BaseClent {

    @Value("${unisound.base.url}")
    private String url;

    @Value("${unisound.base.appkey}")
    private String appKey;

    @Value("${unisound.base.appSecret}")
    private String appSecret;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl(url).filter(logRequest()).build();
    }

    public <T> T operator(final UniSoundRequest request, final Class<T> responseClass) {

        logRequestBody(request.getBody());

        //配置请求方式，参数，请求类型
        WebClient.RequestBodySpec requestBodySpec = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(request.uri())
                        .queryParams(request.queryParams())
                        .build())
                .accept(request.getMediaType())
                .contentType(request.getMediaType())
                .header("appkey", appKey + "@" + appSecret)
                .headers(head -> head.addAll(request.getHead()));

        if (null != request.getBody()) {
            requestBodySpec.body(BodyInserters.fromFormData(request.bodyParams()));
        }

        //接受响应数据
        ResponseEntity<String> responseEntity = requestBodySpec.retrieve().toEntity(String.class).block();

        assert responseEntity != null;
        logResponseBody(responseEntity.getBody());

        T response;
        response = JSONObject.parseObject(responseEntity.getBody(), responseClass);
        return response;
    }

}
