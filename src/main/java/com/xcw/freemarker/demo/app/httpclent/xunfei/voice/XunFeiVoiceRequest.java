package com.xcw.freemarker.demo.app.httpclent.xunfei.voice;

import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

/**
 * @Author xcw
 * @Date 2021/3/2 14:39
 * @Description 描述
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@TypeAlias("/v2/open-ise")
public class XunFeiVoiceRequest  extends XunFeiRequest {
}
