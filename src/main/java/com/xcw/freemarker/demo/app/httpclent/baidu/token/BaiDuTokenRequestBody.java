package com.xcw.freemarker.demo.app.httpclent.baidu.token;

import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuRequestBody;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:09
 * @Description 百度token获取 请求体
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BaiDuTokenRequestBody extends BaiDuRequestBody {
}
