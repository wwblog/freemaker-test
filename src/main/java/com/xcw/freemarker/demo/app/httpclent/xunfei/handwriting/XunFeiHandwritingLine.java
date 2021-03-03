package com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:54
 * @Description 描述
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class XunFeiHandwritingLine {
    float confidence;

    HandwritingDataBlockLineLocation location;

    HandwritingDataBlockLineWord[] word;
}
