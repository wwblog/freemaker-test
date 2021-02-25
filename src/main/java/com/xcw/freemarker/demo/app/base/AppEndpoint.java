package com.xcw.freemarker.demo.app.base;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.core.error.AppException;
import com.xcw.freemarker.demo.core.error.CommonErrorCode;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author xcw
 * @Date 2021/1/18 11:06
 * @Description 请求入口
 */
@Log4j2
@RestController
@RequestMapping("/app")
public class AppEndpoint {
    @Autowired
    AppControl appControl;

    @RequestMapping(value = "/api/{version}/{serviceId}/", method = RequestMethod.POST)
    public AppResponse<?> api(HttpServletRequest request, HttpServletResponse response,
                              @RequestHeader HttpHeaders httpHeaders,
                              @RequestParam MultiValueMap<String, String> queryValue,
                              @PathVariable String version, @PathVariable String serviceId) throws Exception {

        if (StringUtils.isEmpty(version)) {
            throw AppException.of(CommonErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, request.getRequestURI());
        }

        //请求头
        log.info("request headers {}", JSONObject.toJSONString(httpHeaders));
        //入参

       // String so = request.getReader().lines().reduce(String::concat).orElseThrow(IllegalArgumentException::new);
        //log.info("request so {}", so);

        String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        log.info("request body {}", body);

        //路径参数
        AppRequestPathValue pathValue = AppRequestPathValue.builder()
                .version(version)
                .serviceId(serviceId)
                .build();

        //出参
        AppResponse<?> appRespons = appControl.process(httpHeaders, body, pathValue, queryValue);
        log.info("response body {}", JSONObject.toJSONString(appRespons));

        return appRespons;
    }

}
