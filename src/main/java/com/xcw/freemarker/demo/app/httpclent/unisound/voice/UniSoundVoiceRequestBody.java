package com.xcw.freemarker.demo.app.httpclent.unisound.voice;

import com.xcw.freemarker.demo.app.httpclent.unisound.UniSoundRequestBody;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * @Author xcw
 * @Date 2021/3/2 15:39
 * @Description 云之声 参数
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UniSoundVoiceRequestBody extends UniSoundRequestBody {
    /**
     * 需要评测的文本 string格式
     */
    String text;
    /**
     * 评测模式
     * A：最简单模式，结果只有单词打分没有音素信息
     * B：有音素信息，但是没有音素打分
     * C：跟A一样，同时适用于篇章打分
     * D：在B的基础上，有音素打分
     * E：返回words字段里的值，有空格和标点符号，也包含音素打分
     * G：跟D一样
     * H：选择题打分模式
     * 中文支持的模式：
     * E：返回words字段里的值，支持声母、韵母和声调的输出
     */
    String mode;
    /**
     * 语音数据，multipart
     */
    InputStream voice;
}
