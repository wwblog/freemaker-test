package com.xcw.freemarker.demo.app.httpclent.xunfei.voice;

import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 14:41
 * @Description 描述
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class XunFeiVoiceResponse extends XunFeiResponse<XunFeiVoiceData> {
}
