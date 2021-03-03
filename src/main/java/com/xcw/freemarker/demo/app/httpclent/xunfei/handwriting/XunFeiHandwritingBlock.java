package com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:52
 * @Description 描述
 */
@Data
@NoArgsConstructor
@SuperBuilder
public class XunFeiHandwritingBlock {
    XunFeiHandwritingLine[] line;
    String type;
}
