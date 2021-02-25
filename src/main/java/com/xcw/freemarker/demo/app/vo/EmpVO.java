package com.xcw.freemarker.demo.app.vo;

import lombok.*;

import java.io.Serializable;

/**
 * @Author xcw
 * @Date 2021/1/29 14:05
 * @Description 雇员模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class EmpVO implements Serializable {
    private String id;

    private String uId;

    private String uaaId;

    private String psWord;

    private String userName;
}
