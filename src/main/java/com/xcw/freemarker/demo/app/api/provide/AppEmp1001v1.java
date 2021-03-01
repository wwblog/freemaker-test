package com.xcw.freemarker.demo.app.api.provide;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.PageModel;
import com.xcw.freemarker.demo.app.api.vo.EmpVo;
import com.xcw.freemarker.demo.app.base.AppBaseAnonym;
import com.xcw.freemarker.demo.app.base.AppRequest;
import com.xcw.freemarker.demo.app.base.AppResponse;
import com.xcw.freemarker.demo.app.base.AppResponseMeta;
import com.xcw.freemarker.demo.app.service.RpcEmpSercice;
import com.xcw.freemarker.demo.app.vo.EmpVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/18 14:09
 * @Description 描述
 */
@Component
@Log4j2
public class AppEmp1001v1 extends AppBaseAnonym {
    @Autowired
    RpcEmpSercice empService;

    @Override
    public AppRequest<?> instanceRequest(String body) {
        return JSONObject.parseObject(body, AppEmp1001v1Request.class);
    }

    @Override
    public void execute(AppRequest<?> request, AppResponse<?> response) throws Exception {
        AppEmp1001v1Request req = (AppEmp1001v1Request) request;
        AppEmp1001v1RequestData reqData = req.getData();
        log.info("AppEmp1001v1查询所有用户入参为======{}", reqData);
        String code;
        String message;

        Sort sort = Sort.by(Sort.Direction.DESC, "uaaId");
        Pageable page = PageRequest.of(0, 10, sort);
        PageModel<EmpVO> list = empService.findAllEmp(page);
        log.info("AppEmp1001v1查询所有用户出参为======{}", JSONObject.toJSONString(list));


        if (null == list) {
            code = "403";
            message = "数据未找到！";
            AppEmp1001v1Response resData = AppEmp1001v1Response.builder()
                    .code(code)
                    .message(message)
                    .success(false).build();
            response.setData(resData);
            response.setMeta(AppResponseMeta.builder().code(code).message(message).success(false).build());
            return;
        }


        AppEmp1001v1Response resData = AppEmp1001v1Response.builder()
                .data(list.getRows())
                .code("200")
                .message("查询成功")
                .success(true).build();
        response.setData(resData);
        response.setMeta(AppResponseMeta.builder().code("200").message("查询成功").success(true).build());

    }
}
