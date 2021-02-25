package com.xcw.freemarker.demo.app.handwriting;


import com.xcw.freemarker.demo.app.handwriting.config.Base64Util;
import com.xcw.freemarker.demo.app.handwriting.config.FileUtil;
import com.xcw.freemarker.demo.app.handwriting.config.HttpUtil;

import java.net.URLEncoder;

/**
 * @Author xcw
 * @Date 2021/1/28 10:55
 * @Description 文字识别
 */
public class Handwriting {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String handwriting() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/handwriting";
        String url2 = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        String url3 = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";
        try {
            // 本地文件路径
            String filePath = "D:\\photo\\card1.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);

            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.3f6215a1c77015c12696d700b1adb4de.2592000.1614405719.282335-22915441";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Handwriting.handwriting();
    }
}
