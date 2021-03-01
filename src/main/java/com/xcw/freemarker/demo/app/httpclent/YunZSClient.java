package com.xcw.freemarker.demo.app.httpclent;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @Author xcw
 * @Date 2021/3/1 16:05
 * @Description 描述
 */
@Log4j2
@Component
public class YunZSClient extends BaseClent{

    public final String url = "wss://ws-osasr.hivoice.cn/v1/asr";
    public final String appKey = "zb3ocvobrwurnx46t6hruud2ilrkqzj4puytdkyh";
    public final String clientSecret = "dd3e94bcca1608af55c1968bfe3ed370";

    private WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl(url).filter(logRequest()).build();
    }

    public <T> T operator( final YunZSRequest request, final Class<T> responseClass) {

        MultiValueMap<String, String> parameters = queryParams(JSONObject.toJSONString(request));


        //请求参数
        log.info("Request Body: {}", JSONObject.toJSONString(parameters));

        //配置请求方式，参数，请求类型
        WebClient.RequestHeadersSpec<?> requestHeadersSpec = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParams(parameters)
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
