package com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:56
 * @Description 描述
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class HandwritingDataBlockLineLocation {
    HandwritingDataBlockLineLocationTopleft top_left;

    HandwritingDataBlockLineLocationRightbottom right_bottom;
}
