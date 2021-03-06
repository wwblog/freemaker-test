package com.xcw.freemarker.demo.app.api.provide;

import com.xcw.freemarker.demo.app.base.AppRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/1/18 14:11
 * @Description 描述
 */

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AppEmp1002v1Request extends AppRequest<AppEmp1002v1RequestData> {


}
