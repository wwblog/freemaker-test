package com.xcw.freemarker.demo.app.httpclent;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.R;

/**
 * @Author xcw
 * @Date 2021/3/1 12:08
 * @Description 第三方客户端
 */
@Log4j2
public class BaseClent {


    protected ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            log.info("Request URL: {} {}", clientRequest.method(), clientRequest.url());
            log.debug("Request Head: ");
            clientRequest.headers()
                    .forEach((name, values) -> values.forEach(value -> log.debug("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }



public MultiValueMap<String, String> queryParams(String request){
    //请求参数转换为MultiValueMap类型
    MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
    Map<String, Object> maps = JSONObject.parseObject(request, Map.class);
    if(null!=maps && !maps.isEmpty()) {
        for (String key : maps.keySet()) {
            Object val = maps.get(key);
            if(null!=val) {
                if(val instanceof List){
                    parameters.addAll(key, (List) val);
                }else{
                    parameters.add(key, String.valueOf(val));
                }
            }
        }
    }
    return parameters;
}


}