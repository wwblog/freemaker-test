package com.xcw.freemarker.demo.app.httpclent.xunfei;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.httpclent.BaseClent;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

/**
 * @Author xcw
 * @Date 2021/3/1 16:05
 * @Description 描述
 */
@Log4j2
@Component
public class XunFeiClient extends BaseClent {

    public final String url = "https://webapi.xfyun.cn/v1/service/v1/ocr/handwriting";
    public final String clientId = "OqMCNiTnWfoPjqMBY4G9I1Q2";
    public final String clientSecret = "HrdkZmCxdiCSPK8U3vN8GaABtzfpXYgl";

    private WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl(url).filter(logRequest()).build();
    }

    public <T> T operator(final XunFeiRequest request, final Class<T> responseClass) {

        MultiValueMap<String, String> map = queryParams(JSONObject.toJSONString(request));

        //请求参数
        log.info("Request Body: {}", JSONObject.toJSONString(map));

        //配置请求方式，参数，请求类型
        WebClient.RequestHeadersSpec<?> requestHeadersSpec = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .queryParams(map)
                        .build())
                .accept(MediaType.APPLICATION_JSON);

        //接受响应数据
        String clientResponse = requestHeadersSpec.retrieve()
                .bodyToMono(String.class)
                .block();

        log.info("response ======={}", clientResponse);

        T response;
        response = JSONObject.parseObject(clientResponse, responseClass);
        return response;
    }

}
