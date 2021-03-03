package com.xcw.freemarker.demo.app.httpclent.unisound;

import com.xcw.freemarker.demo.app.httpclent.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

/**
 * @Author xcw
 * @Date 2021/3/1 17:08
 * @Description 描述
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UniSoundRequest extends BaseRequest<UniSoundRequestQuery, UniSoundRequestBody> {
    /**
     * 音频格式
     * 可选值 mp3/silk/opus/amrnb/wxspeex
     */
    public static String audioFormat;

    @Override
    protected String uri() {
        StringBuilder uri = new StringBuilder("");
        TypeAlias t = this.getClass().getAnnotation(TypeAlias.class);
        uri.append(t.value());
        uri.append(audioFormat);
        return uri.toString();
    }

}
