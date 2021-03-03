package com.xcw.freemarker.demo.app.httpclent.unisound;

import com.xcw.freemarker.demo.app.httpclent.BaseRequestBody;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 15:29
 * @Description 描述
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UniSoundRequestBody extends BaseRequestBody {
}
