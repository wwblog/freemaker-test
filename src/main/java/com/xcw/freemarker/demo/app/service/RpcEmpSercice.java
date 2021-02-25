package com.xcw.freemarker.demo.app.service;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.api.vo.EmpAndEmpJobVo;
import com.xcw.freemarker.demo.app.api.vo.EmpVo;
import com.xcw.freemarker.demo.app.entity.EmpEntity;
import com.xcw.freemarker.demo.app.vo.EmpVO;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/19 11:15
 * @Description 描述
 */
public interface RpcEmpSercice {
    /**
     * 根据uId查询所有雇员
     *
     * @param uId
     * @return
     */
    public List<EmpVO> findEmpEntityByUId(String uId);

    /**
     * 查询所有emp
     */
    public List<EmpVO> findAllEmp();

    /**
     * 根据username模糊查找emp
     */
    public List<EmpVO> findEmpEntityByUserName(EmpVO vo);

    /**
     * 查询雇员类型
     */
    public List<EmpAndEmpJobVo> findEmpAndEmpJob();
}
