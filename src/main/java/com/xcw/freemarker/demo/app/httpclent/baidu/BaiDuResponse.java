package com.xcw.freemarker.demo.app.httpclent.baidu;

import lombok.Data;

/**
 * @Author xcw
 * @Date 2021/3/1 13:03
 * @Description 描述
 */
@Data
public class BaiDuResponse {

    String access_token;

    /**
     * Access Token的有效期(秒为单位，一般为1个月)
     */
    String expires_in;

}
