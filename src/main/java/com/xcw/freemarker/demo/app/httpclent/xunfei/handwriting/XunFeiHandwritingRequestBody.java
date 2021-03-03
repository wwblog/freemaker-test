package com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting;

import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiRequestBody;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:09
 * @Description 讯飞云手写识别请求参数
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class XunFeiHandwritingRequestBody extends XunFeiRequestBody {
    /**
     * Base64 编码后的图片数据
     */
    String image;
}
