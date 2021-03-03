package com.xcw.freemarker.demo.app.httpclent.xunfei.voice;

import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiRequestBody;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 14:41
 * @Description 描述
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class XunFeiVoiceRequestBody extends XunFeiRequestBody {
    /**
     * base64 编码后进行 urlencode 大小不超过5M
     * 必须
     */
    String audio;
    /**
     * 评测文本（使用 utf-8 编码）
     * 长度中文不超过180字节、英文不超过300字节
     */
    String text;
}
