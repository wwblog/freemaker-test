package com.xcw.freemarker.demo.app.httpclent.baidu;

import lombok.Builder;
import lombok.Data;

/**
 * @Author xcw
 * @Date 2021/3/1 12:22
 * @Description 描述
 */
@Data
@Builder
public class BaiDuRequest {
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
