package com.xcw.freemarker.demo.app.httpclent.unisound.voice;

import com.xcw.freemarker.demo.app.httpclent.unisound.UniSoundRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

/**
 * @Author xcw
 * @Date 2021/3/2 15:39
 * @Description 描述
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@TypeAlias("")
public class UniSoundVoiceRequest extends UniSoundRequest {
}
