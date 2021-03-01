package com.xcw.freemarker.demo.app.service;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.PageModel;
import com.xcw.freemarker.demo.app.api.vo.EmpAndEmpJobVo;
import com.xcw.freemarker.demo.app.api.vo.EmpVo;
import com.xcw.freemarker.demo.app.entity.EmpAndEmpJobDo;
import com.xcw.freemarker.demo.app.entity.EmpEntity;
import com.xcw.freemarker.demo.app.mapper.EmpMapper;
import com.xcw.freemarker.demo.app.vo.EmpVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/19 11:39
 * @Description 描述
 */
@Service
@Log4j2
public class EmpService implements RpcEmpSercice {

    @Autowired
    EmpMapper empMapper;

    @Override
    public List<EmpVO> findEmpEntityByUId(String uId) {
        return empMapper.findEmpEntityByUId(uId);
    }

    @Override
    public PageModel<EmpVO> findAllEmp(Pageable pageable) {
        PageModel<EmpVO> empVOList = empMapper.findAll(pageable);
        log.info("EmpService,查询到的数据为====={}", JSONObject.toJSONString(empVOList));
        return empVOList;
    }

    @Override
    public List<EmpVO> findEmpEntityByUserName(EmpVO vo) {
        List<EmpVO> empVOList = empMapper.findEmpEntityByUserName(vo);
        log.info("EmpService根据username模糊查找emp,查询到的数据为====={}", JSONObject.toJSONString(empVOList));
        return empVOList;
    }

    @Override
    public List<EmpAndEmpJobVo> findEmpAndEmpJob() {
        List<EmpAndEmpJobDo> empEntityList = empMapper.findEmpAndEmpJob();
        log.info("EmpService查询所有emp以及职业类型,查询到的数据为====={}", JSONObject.toJSONString(empEntityList));
        List<EmpAndEmpJobVo> list = JSONObject.parseArray(JSONObject.toJSONString(empEntityList), EmpAndEmpJobVo.class);
        return list;
    }


}
