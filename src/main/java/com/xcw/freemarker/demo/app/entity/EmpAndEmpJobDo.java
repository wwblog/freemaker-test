package com.xcw.freemarker.demo.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Author xcw
 * @Date 2021/1/19 15:28
 * @Description 描述
 */
@Data
@Builder
@AllArgsConstructor
public class EmpAndEmpJobDo {
    private String id;

    private String uId;

    private String psWord;

    private String userName;

    private String jobName;

}
