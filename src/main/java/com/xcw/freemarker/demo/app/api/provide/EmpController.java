package com.xcw.freemarker.demo.app.api.provide;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.PageModel;
import com.xcw.freemarker.demo.app.entity.EmpEntity;
import com.xcw.freemarker.demo.app.repository.EmpConvertor;
import com.xcw.freemarker.demo.app.service.EmpService;
import com.xcw.freemarker.demo.app.service.RpcEmpSercice;
import com.xcw.freemarker.demo.app.vo.EmpVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/29 18:23
 * @Description 描述
 */
@RestController
@Log4j2
public class EmpController {
    @Autowired
    RpcEmpSercice empService;

    @Autowired
    EmpConvertor convertor;

    @GetMapping("/findAllByuId/{uId}")
    public List<EmpVO> findAllByuId(@PathVariable String uId) {
        log.info("传入的uid======{}", uId);
        return empService.findEmpEntityByUId(uId);
    }

    @GetMapping("/mapstructTest")
    public List<EmpEntity> mapstructTest(){
        PageModel<EmpVO> empVOList = empService.findAllEmp(null);
        System.out.println(JSONObject.toJSONString(empVOList));

        List<EmpEntity> empEntityList = convertor.toEntity(empVOList.getRows());
        System.out.println(JSONObject.toJSONString(empEntityList));

        return  empEntityList;
    }
}
