package com.xcw.freemarker.demo.app.httpclent;

import lombok.Builder;
import lombok.Data;

/**
 * @Author xcw
 * @Date 2021/3/1 17:08
 * @Description 描述
 */
@Data
@Builder
public class YunZSRequest {
    String time;
    String appkey;
    String sign;
}
