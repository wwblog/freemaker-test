package com.xcw.freemarker.demo.app.httpclent.baidu.token;

import com.xcw.freemarker.demo.app.httpclent.BaseResponse;
import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:09
 * @Description 百度token获取
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaiDuTokenResponse <T> extends BaseResponse<T> {

    String access_token;//24.66709791b240d6f398ef3092d6ce799f.2592000.1617330927.282335-22915441
    /**
     * Access Token的有效期(秒为单位，一般为1个月)
     */
    String expires_in;
}
