package com.xcw.freemarker.demo.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.PageModel;
import com.xcw.freemarker.demo.app.ResultModel;
import com.xcw.freemarker.demo.app.entity.EmpEntity;
import com.xcw.freemarker.demo.app.repository.EmpConvertor;
import com.xcw.freemarker.demo.app.service.RpcEmpSercice;
import com.xcw.freemarker.demo.app.vo.EmpVO;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public PageModel<EmpVO> list(HttpServletRequest request) {
        String pageNumber = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");

        Integer number = StringUtils.isNotBlank(pageNumber) ? Integer.parseInt(pageNumber) : 1;
        Integer size = StringUtils.isNotBlank(pageSize) ? Integer.parseInt(pageSize) : 10;

        Sort sort = Sort.by(Sort.Direction.DESC, "uaaId");
        Pageable page = PageRequest.of(number - 1, size, sort);
        PageModel<EmpVO> resultPage = empService.findAllEmp(page);
        log.info(" PersonManageController list 所有emp======{}", JSONObject.toJSONString(resultPage));

        return resultPage;
    }
}
