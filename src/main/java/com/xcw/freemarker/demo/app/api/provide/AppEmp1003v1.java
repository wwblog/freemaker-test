package com.xcw.freemarker.demo.app.api.provide;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.api.vo.EmpAndEmpJobVo;
import com.xcw.freemarker.demo.app.api.vo.EmpVo;
import com.xcw.freemarker.demo.app.base.AppBaseAnonym;
import com.xcw.freemarker.demo.app.base.AppRequest;
import com.xcw.freemarker.demo.app.base.AppResponse;
import com.xcw.freemarker.demo.app.base.AppResponseMeta;
import com.xcw.freemarker.demo.app.service.RpcEmpSercice;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/18 14:09
 * @Description 描述
 */
@Component
@Log4j2
public class AppEmp1003v1 extends AppBaseAnonym {
    @Autowired
    RpcEmpSercice empService;

    @Override
    public AppRequest<?> instanceRequest(String body) {
        return JSONObject.parseObject(body, AppEmp1003v1Request.class);
    }

    @Override
    public void execute(AppRequest<?> request, AppResponse<?> response) throws Exception {
        AppEmp1003v1Request req = (AppEmp1003v1Request) request;
        AppEmp1003v1RequestData reqData = req.getData();
        log.info("AppEmp1003v1查询所有用户入参为======{}", JSONObject.toJSONString(reqData));
        String code;
        String message;


        List<EmpAndEmpJobVo> list = empService.findEmpAndEmpJob();
        log.info("AppEmp1003v1查询所有用户出参为======{}", JSONObject.toJSONString(list));


        if (list.isEmpty()) {
            code = "403";
            message = "数据未找到！";
            AppEmp1003v1Response resData = AppEmp1003v1Response.builder()
                    .code(code)
                    .message(message)
                    .build();
            response.setData(resData);
            response.setMeta(AppResponseMeta.builder().code(code).message(message).build());
            return;
        }


        AppEmp1003v1Response resData = AppEmp1003v1Response.builder()
                .data(list)
                .code("200")
                .message("查询成功")
                .success(true)
                .build();
        response.setData(resData);
        response.setMeta(AppResponseMeta.builder().code("200").message("查询成功").success(true).build());

    }
}
