package com.xcw.freemarker.demo.app.httpclent.unisound.voice;

import com.xcw.freemarker.demo.app.httpclent.unisound.UniSoundRequestQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 15:39
 * @Description 云之声路径参数
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UniSoundVoiceRequestQuery extends UniSoundRequestQuery {
}
