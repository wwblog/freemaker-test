package com.xcw.freemarker.demo.app.httpclent.baidu;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.httpclent.BaseClent;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * @Author xcw
 * @Date 2021/3/1 16:05
 * @Description 描述
 */
@Log4j2
@Component
public class BaiDuClient extends BaseClent {

    @Value("${baidu.base.url}")
    private String url;

    @Value("${baidu.base.appId}")
    private String appId;

    @Value("${baidu.base.appKey}")
    private String appKey;

    @Value("${baidu.base.appSecret}")
    private String appSecret;


    private WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl(url).filter(logRequest()).build();
    }

    public <T> T operator(final BaiDuRequest request, final Class<T> responseClass) {

        logRequestBody(request.getBody());

        request.getQuery().setGrant_type("client_credentials");
        request.getQuery().setClient_id(appKey);
        request.getQuery().setClient_secret(appSecret);

        //配置请求方式，参数，请求类型
        WebClient.RequestBodySpec requestBodySpec = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(request.uri())
                        .queryParams(request.queryParams())
                        .build())
                .contentType(request.getMediaType())
                .accept(request.getMediaType());

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
