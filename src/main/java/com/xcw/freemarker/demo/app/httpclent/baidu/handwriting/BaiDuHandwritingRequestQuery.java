package com.xcw.freemarker.demo.app.httpclent.baidu.handwriting;

import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuRequestQuery;
import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiRequestQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:09
 * @Description 百度手写识别请求参数
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BaiDuHandwritingRequestQuery extends BaiDuRequestQuery {
    String access_token;
}
