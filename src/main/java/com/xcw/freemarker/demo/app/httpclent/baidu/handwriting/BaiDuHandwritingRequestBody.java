package com.xcw.freemarker.demo.app.httpclent.baidu.handwriting;

import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuRequestBody;
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
public class BaiDuHandwritingRequestBody extends BaiDuRequestBody {
    /**
     * Base64 编码后的图片数据
     */
    String image;
}
