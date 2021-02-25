package com.xcw.freemarker.demo.app.api.provide;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.api.vo.EmpVo;
import com.xcw.freemarker.demo.app.base.AppBaseAnonym;
import com.xcw.freemarker.demo.app.base.AppRequest;
import com.xcw.freemarker.demo.app.base.AppResponse;
import com.xcw.freemarker.demo.app.base.AppResponseMeta;
import com.xcw.freemarker.demo.app.service.RpcEmpSercice;
import com.xcw.freemarker.demo.app.vo.EmpVO;
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
public class AppEmp1002v1 extends AppBaseAnonym {
    @Autowired
    RpcEmpSercice empService;

    @Override
    public AppRequest<?> instanceRequest(String body) {
        return JSONObject.parseObject(body, AppEmp1002v1Request.class);
    }

    @Override
    public void execute(AppRequest<?> request, AppResponse<?> response) throws Exception {
        AppEmp1002v1Request req = (AppEmp1002v1Request) request;
        AppEmp1002v1RequestData reqData = req.getData();
        log.info("AppEmp1002v1查询所有用户入参为======{}", JSONObject.toJSONString(reqData));
        String code;
        String message;

        //用户名称
        String userName = reqData.getUserName();

        if(StringUtils.isEmpty(userName)){
            code = "400";
            message = "参数无效！";
            response.setMeta(AppResponseMeta.builder().code(code).message(message).build());
            return;
        }


        EmpVO vo = EmpVO.builder().userName(userName).build();
        List<EmpVO> list = empService.findEmpEntityByUserName(vo);
        log.info("AppEmp1002v1查询所有用户出参为======{}", JSONObject.toJSONString(list));


        if (list.isEmpty()) {
            code = "403";
            message = "数据未找到！";
            AppEmp1002v1Response resData = AppEmp1002v1Response.builder()
                    .code(code)
                    .message(message)
                    .success(false).build();
            response.setData(resData);
            response.setMeta(AppResponseMeta.builder().code(code).message(message).success(false).build());
            return;
        }


        AppEmp1002v1Response resData = AppEmp1002v1Response.builder()
                .data(list)
                .code("200")
                .message("查询成功")
                .success(true).build();
        response.setData(resData);
        response.setMeta(AppResponseMeta.builder().code("200").message("查询成功").success(true).build());

    }
}
