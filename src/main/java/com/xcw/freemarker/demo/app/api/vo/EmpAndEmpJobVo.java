package com.xcw.freemarker.demo.app.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author xcw
 * @Date 2021/1/19 15:54
 * @Description 雇员信息+雇员职业类型
 */
@Data
@Builder
@AllArgsConstructor
public class EmpAndEmpJobVo implements Serializable {
    private String id;

    private String uId;

    private String psWord;

    private String userName;

    private String jobName;
}
