package com.xcw.freemarker.demo.app.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/1/18 11:12
 * @Description 描述
 */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class AppResponse<T extends AppResponseData> {

    String traceId;

    private AppResponseMeta meta;

    private AppResponseData data;

}
