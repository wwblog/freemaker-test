package com.xcw.freemarker.demo.app.httpclent.baidu;

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
@EqualsAndHashCode(callSuper = false)
public class BaiDuResponse<T> extends BaseResponse<T> {

}
