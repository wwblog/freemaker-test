package com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting;

import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:09
 * @Description 手写识别出参类
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class XunFeiHandwritingResponse extends XunFeiResponse<XunFeiHandwritingData> {
}
