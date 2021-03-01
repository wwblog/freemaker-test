package com.xcw.freemarker.demo.app.httpclent;

import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuClient;
import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuRequest;
import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @Author xcw
 * @Date 2021/3/1 13:01
 * @Description 描述
 */
@RestController
public class BaseTest {
    @Autowired
    BaiDuClient clent;

    @Autowired
    YunZSClient yClient;

    @RequestMapping("/baseTest")
    public BaiDuResponse baseTest(){
        BaiDuRequest req = BaiDuRequest.builder().grant_type("client_credentials")
                .client_id("OqMCNiTnWfoPjqMBY4G9I1Q2")
                .client_secret("HrdkZmCxdiCSPK8U3vN8GaABtzfpXYgl")
                .build();
        BaiDuResponse res =clent.operator(req, BaiDuResponse.class);
        return  res;
    }


    @RequestMapping("/YunZSJCheck")
    public String getSign(String appkey, String timestamp, String secret) {
        appkey="zb3ocvobrwurnx46t6hruud2ilrkqzj4puytdkyh";
        timestamp = String.valueOf(System.currentTimeMillis());
        secret = "dd3e94bcca1608af55c1968bfe3ed370";
        String originalStr = appkey + timestamp + secret;
        StringBuilder sign = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(originalStr.getBytes(StandardCharsets.UTF_8));
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(bytes[i] & 0xFF);
                if (hex.length() == 1) {
                    sign.append("0");
                }
                sign.append(hex.toUpperCase());
            }
        } catch (Exception ignored) {
        }
        return sign.toString();
    }

    //云之声语音识别
    @RequestMapping("/yunZhiSheng")
    public BaiDuResponse yunZhiSheng(){
        String appkey="zb3ocvobrwurnx46t6hruud2ilrkqzj4puytdkyh";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String sign = getSign(null,null,null);

        YunZSRequest yunZSRequest = YunZSRequest.builder().appkey(appkey).time(timestamp).sign(sign).build();
        BaiDuResponse res =yClient.operator(yunZSRequest, BaiDuResponse.class);
        return  res;
    }


}
