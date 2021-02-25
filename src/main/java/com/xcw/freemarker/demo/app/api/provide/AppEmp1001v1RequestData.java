package com.xcw.freemarker.demo.app.api.provide;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/1/18 14:12
 * @Description 描述
 */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class AppEmp1001v1RequestData{
    /**
     * 当前页
     */
    Integer page;
}
