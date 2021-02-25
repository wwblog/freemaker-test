package com.xcw.freemarker.demo.app.controller;

import com.xcw.freemarker.demo.app.ResultModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author xcw
 * @Date 2021/2/5 9:49
 * @Description 图片上传页面
 */
@Controller
@RequestMapping("/imgManage")
@Log4j2
public class UpLoadImgController {


    @RequestMapping("/list")
    public ModelAndView listPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/imgManage/list");
        return mv;
    }

    @RequestMapping("/imgList")
    @ResponseBody
    public ResultModel imgList() {
        return ResultModel.builder().success(true).data(null).build();
    }
}
