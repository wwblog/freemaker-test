package com.xcw.freemarker.demo.app.httpclent.baidu.token;

import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

/**
 * @Author xcw
 * @Date 2021/3/2 10:06
 * @Description 百度token获取
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@TypeAlias("/oauth/2.0/token")
public class BaiDuTokenRequest extends BaiDuRequest {


}
