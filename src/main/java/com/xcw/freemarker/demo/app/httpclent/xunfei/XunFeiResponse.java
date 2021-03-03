package com.xcw.freemarker.demo.app.httpclent.xunfei;

import com.xcw.freemarker.demo.app.httpclent.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/1 13:03
 * @Description 描述
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class XunFeiResponse <T> extends BaseResponse<T> {
    /**
     * 结果码  https://www.xfyun.cn/document/error-code
     */
    String code;

    /**
     * 	描述
     */
    String desc;

    /**
     * 	会话ID
     */
    String sid;

}
