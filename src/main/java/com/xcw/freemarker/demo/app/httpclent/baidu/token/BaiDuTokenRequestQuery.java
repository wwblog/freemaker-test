package com.xcw.freemarker.demo.app.httpclent.baidu.token;

import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuRequestQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:09
 * @Description 百度token获取 路径参数
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BaiDuTokenRequestQuery extends BaiDuRequestQuery {

    /**
     * 必须参数，固定为client_credentials
     */
    private String grant_type;

    /**
     * 必须参数，应用的API Key
     */
    private String client_id;

    /**
     * 必须参数，应用的Secret Key
     */
    private String client_secret;
}
