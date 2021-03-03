package com.xcw.freemarker.demo.app.httpclent.baidu;

import com.xcw.freemarker.demo.app.httpclent.BaseRequestQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/3 9:41
 * @Description 百度路径参数
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class BaiDuRequestQuery extends BaseRequestQuery {

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
