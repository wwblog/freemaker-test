package com.xcw.freemarker.demo.app.httpclent.baidu.handwriting;

import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

/**
 * @Author xcw
 * @Date 2021/3/2 10:06
 * @Description 百度手写识别
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@TypeAlias("/rest/2.0/ocr/v1/handwriting")
public class BaiDuHandwritingRequest extends BaiDuRequest {

}
