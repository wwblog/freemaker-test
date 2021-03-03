package com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:16
 * @Description 出参类
 */
@Data
@NoArgsConstructor
@SuperBuilder
public class XunFeiHandwritingData {
    XunFeiHandwritingBlock[] block;
}