package com.xcw.freemarker.demo.app.httpclent;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * @Author xcw
 * @Date 2021/3/2 9:37
 * @Description 基础请求类
 */
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class BaseRequest <Query extends BaseRequestQuery,Body extends BaseRequestBody> {

    @Builder.Default
    protected HttpMethod httpMethod = HttpMethod.POST;

    @Builder.Default
    protected MediaType mediaType = MediaType.APPLICATION_JSON;

    protected  BaseRequestHead head;

    protected Query query;

    protected Body body;


    abstract protected String uri();

    /**
     * get 访问参数
     * @return
     */
    public MultiValueMap<String, String> queryParams(){
        //请求参数转换为MultiValueMap类型
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        Map<String, Object> maps = JSONObject.parseObject(JSONObject.toJSONString(query), Map.class);
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


    /**
     * post 访问参数
     * @return
     */
    public MultiValueMap<String, String> bodyParams(){
        //请求参数转换为MultiValueMap类型
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        Map<String, Object> maps = JSONObject.parseObject(JSONObject.toJSONString(body), Map.class);
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
