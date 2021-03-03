package com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting;

import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

/**
 * @Author xcw
 * @Date 2021/3/2 10:06
 * @Description 讯飞云手写识别
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@TypeAlias("/v1/service/v1/ocr/handwriting")
public class XunFeiHandwritingRequest extends XunFeiRequest {


}
