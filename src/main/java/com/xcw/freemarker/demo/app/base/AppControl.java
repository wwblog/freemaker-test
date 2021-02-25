package com.xcw.freemarker.demo.app.base;

import com.xcw.freemarker.demo.core.error.AppException;
import com.xcw.freemarker.demo.core.error.CommonErrorCode;
import lombok.extern.log4j.Log4j2;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/18 12:50
 * @Description 请求处理类
 */
@Log4j2
@Component
public class AppControl {

    @Autowired
    private List<AppCmd> appCmds;

    private HashMap<String, AppCmd> cmdApis = new HashMap<>();


    @PostConstruct
    public void init() {
        //初始化参数
        appCmds.forEach(cmd -> {
            cmdApis.put(cmd.getPath(), cmd);
            log.info("api add : /api/{}/{}/", cmd.getVer(), cmd.getId());
        });
    }


    public AppResponse<?> process(final MultiValueMap<String, String> headers, final String body,
                                  final AppRequestPathValue pathValue,
                                  final MultiValueMap<String, String> queryValue) throws Exception {

        String cmdId = pathValue.getVersion() + "/" + pathValue.getServiceId();

        AppCmd cmd = cmdApis.get(cmdId);

        AppRequest<?> request = cmd.instanceRequest(body);
        if (null == request) {
            throw AppException.of(CommonErrorCode.INVALID_ARGUMENT, HttpStatus.BAD_REQUEST, body, cmdId);
        }
        request.setHeaders(headers);
        request.setPathValue(pathValue);
        request.setQueryValue(queryValue);
        //request.setTraceId(TraceContext.);

        //判断是否登录
        if (!cmd.allow(request)) {
            throw AppException.of(CommonErrorCode.NON_AUTHORITATIVE_INFORMATION, HttpStatus.NON_AUTHORITATIVE_INFORMATION, cmdId);
        }

        AppResponse<?> response = AppResponse.builder().build();
        cmd.execute(request, response);

        //出参赋值时间
        response.getMeta().setTime(DateTime.now().toDate());

        //response.setTraceId(TraceContext.traceId());

        return response;
    }


}
