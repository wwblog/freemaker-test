package com.xcw.freemarker.demo.app.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/1/18 11:39
 * @Description 路径参数
 */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
public class AppRequestPathValue {
    private String version;
    private String serviceId;
}
