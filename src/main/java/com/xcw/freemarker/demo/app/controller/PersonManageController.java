package com.xcw.freemarker.demo.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.ResultModel;
import com.xcw.freemarker.demo.app.entity.EmpEntity;
import com.xcw.freemarker.demo.app.repository.EmpConvertor;
import com.xcw.freemarker.demo.app.service.RpcEmpSercice;
import com.xcw.freemarker.demo.app.vo.EmpVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/2/5 9:49
 * @Description 图片上传页面
 */
@Controller
@RequestMapping("/personManage")
@Log4j2
public class PersonManageController {
    @Autowired
    RpcEmpSercice empService;

    @Autowired
    EmpConvertor convertor;

    @RequestMapping("/list")
    public ModelAndView listPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/web/personManage/list");
        return mv;
    }

    @RequestMapping("/empList")
    @ResponseBody
    public List<EmpVO> list() {
        List<EmpVO> empVOList = empService.findAllEmp();
        log.info(" PersonManageController list 所有emp======{}",JSONObject.toJSONString(empVOList));
        return  empVOList;
    }
}
