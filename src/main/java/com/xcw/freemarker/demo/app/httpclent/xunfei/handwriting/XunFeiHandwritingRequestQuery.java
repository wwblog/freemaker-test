package com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting;

import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiRequestQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * @Author xcw
 * @Date 2021/3/2 10:09
 * @Description 讯飞云手写识别请求参数
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class XunFeiHandwritingRequestQuery extends XunFeiRequestQuery {
    /**
     * 必须有值
     * 语言，可选值：en（英文），cn|en（中文或中英混合）
     */
    String language;

    /**
     * 是否返回文本位置信息，可选值：false（否），true（是），默认为false
     */
    String location;

    /**
     * 手机序列号
     */
    String imei;

    /**
     * 操作系统版本
     */
    String osid;

    /**
     * 厂商|全称|机型信息|操作系统版本|分辨率
     * 	vivo|vivoY67L|PD1612|ANDROID6.0|720*1280
     */
    String ua;

}
