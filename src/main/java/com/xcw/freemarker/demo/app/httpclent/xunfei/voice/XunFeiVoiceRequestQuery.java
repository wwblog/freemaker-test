package com.xcw.freemarker.demo.app.httpclent.xunfei.voice;

import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiRequestQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 14:41
 * @Description 路径请求参数
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class XunFeiVoiceRequestQuery extends XunFeiRequestQuery {
    /**
     * 音频编码 raw（未压缩的 pcm 格式音频）  speex（标准开源speex）
     * 示例 raw
     * 是否必须 是
     */
    String aue;
    /**
     * 当aue=speex时，若传此参数，表明音频格式为标准speex
     * 示例	70
     * 是否必须 否
     */
    String speex_size;
    /**
     * 评测结果等级 entirety（默认值） simple
     * 示例 entirety
     * 是否必须 否
     */
    String result_level;
    /**
     * 语言，可选值：en_us（英语）zh_cn（汉语）
     * 示例 zh_cn
     * 是否必须 是
     */
    String language;

    /**
     * 评测题型 read_syllable（单字朗读，汉语专有） read_word（词语朗读） read_sentence（句子朗读） read_chapter(篇章朗读)
     * 示例 read_sentence
     * 是否必须 是
     */
    String category;
    /**
     * 拓展能力 multi_dimension(全维度 )
     * 示例 multi_dimension
     * 是否必须 否
     */
    String extra_ability;
}
