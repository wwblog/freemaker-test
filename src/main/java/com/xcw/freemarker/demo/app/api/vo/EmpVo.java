package com.xcw.freemarker.demo.app.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author xcw
 * @Date 2021/1/19 11:35
 * @Description 雇员信息
 */
@Data
@Builder
@AllArgsConstructor
public class EmpVo implements Serializable {
    private String id;

    private String uId;

    private String psWord;

    private String userName;
}
