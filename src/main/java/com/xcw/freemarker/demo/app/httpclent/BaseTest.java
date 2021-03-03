package com.xcw.freemarker.demo.app.httpclent;

import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuClient;
import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuRequest;
import com.xcw.freemarker.demo.app.httpclent.baidu.BaiDuResponse;
import com.xcw.freemarker.demo.app.httpclent.baidu.handwriting.BaiDuHandwritingRequest;
import com.xcw.freemarker.demo.app.httpclent.baidu.handwriting.BaiDuHandwritingRequestBody;
import com.xcw.freemarker.demo.app.httpclent.baidu.handwriting.BaiDuHandwritingRequestQuery;
import com.xcw.freemarker.demo.app.httpclent.baidu.handwriting.BaiDuHandwritingResponse;
import com.xcw.freemarker.demo.app.httpclent.baidu.token.BaiDuTokenRequest;
import com.xcw.freemarker.demo.app.httpclent.baidu.token.BaiDuTokenRequestQuery;
import com.xcw.freemarker.demo.app.httpclent.baidu.token.BaiDuTokenResponse;
import com.xcw.freemarker.demo.app.httpclent.unisound.voice.UniSoundVoiceRequest;
import com.xcw.freemarker.demo.app.httpclent.unisound.voice.UniSoundVoiceRequestBody;
import com.xcw.freemarker.demo.app.httpclent.unisound.voice.UniSoundVoiceResponse;
import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiClient;
import com.xcw.freemarker.demo.app.httpclent.xunfei.XunFeiVoiceClient;
import com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting.XunFeiHandwritingRequest;
import com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting.XunFeiHandwritingRequestBody;
import com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting.XunFeiHandwritingRequestQuery;
import com.xcw.freemarker.demo.app.httpclent.xunfei.handwriting.XunFeiHandwritingResponse;
import com.xcw.freemarker.demo.app.httpclent.unisound.UniSoundClient;
import com.xcw.freemarker.demo.app.httpclent.unisound.UniSoundRequest;
import com.xcw.freemarker.demo.app.httpclent.xunfei.voice.XunFeiVoiceRequest;
import com.xcw.freemarker.demo.app.httpclent.xunfei.voice.XunFeiVoiceRequestBody;
import com.xcw.freemarker.demo.app.httpclent.xunfei.voice.XunFeiVoiceRequestQuery;
import com.xcw.freemarker.demo.app.httpclent.xunfei.voice.XunFeiVoiceResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;

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
    UniSoundClient uClient;

    @Autowired
    XunFeiClient xClient;

    @Autowired
    XunFeiVoiceClient xVoiceClient;


    @RequestMapping("/baiduToken")
    public BaiDuTokenResponse baiduToken() {
        BaiDuTokenRequest req = BaiDuTokenRequest.builder()
                .query(BaiDuTokenRequestQuery.builder().build())
                .mediaType(MediaType.APPLICATION_FORM_URLENCODED)
                .build();
        BaiDuTokenResponse res = clent.operator(req, BaiDuTokenResponse.class);
        return res;
    }

    @RequestMapping("/baiduHandWriting")
    public BaiDuHandwritingResponse baiduHandWriting(MultipartFile file) throws IOException {
        String image = new String(Base64.encodeBase64(file.getBytes()));

        BaiDuHandwritingRequest req = BaiDuHandwritingRequest.builder()
                .query(BaiDuHandwritingRequestQuery.builder()
                        .access_token("24.66709791b240d6f398ef3092d6ce799f.2592000.1617330927.282335-22915441")
                        .build())
                .body(BaiDuHandwritingRequestBody.builder().image(image).build())
                .mediaType(MediaType.APPLICATION_FORM_URLENCODED)
                .build();
        BaiDuHandwritingResponse res = clent.operator(req, BaiDuHandwritingResponse.class);
        return res;
    }


    @RequestMapping("/YunZSJCheck")
    public String getSign(String appkey, String timestamp, String secret) {
        appkey = "zb3ocvobrwurnx46t6hruud2ilrkqzj4puytdkyh";
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
    public UniSoundVoiceResponse yunZhiSheng(MultipartFile file) throws IOException {
        FileSystemResource resource = new FileSystemResource(new File("D:\\photo\\01.mp3"));
        File file1 = resource.getFile();
        InputStream stream = file.getInputStream();

        BaseRequestHead head = new BaseRequestHead();
        head.set("session-id", UUID.randomUUID().toString());
        head.set("Wrap-Create-Time", "true");
        UniSoundRequest.audioFormat = "/mp3";
        UniSoundVoiceRequest request = UniSoundVoiceRequest.builder()
                .head(head)
                .body(UniSoundVoiceRequestBody.builder()
                        .text("学而时习之，不亦说乎。")
                        .mode("A")
                        .voice(stream)
                        .build())
                .build();


        UniSoundVoiceResponse res = uClient.operator(request, UniSoundVoiceResponse.class);
        return res;
    }

    @RequestMapping("/xfy")
    public XunFeiHandwritingResponse xunfeiyun(MultipartFile file) throws IOException {
        String image = new String(Base64.encodeBase64(file.getBytes()));

        XunFeiHandwritingRequest request = XunFeiHandwritingRequest.builder()
                .query(XunFeiHandwritingRequestQuery.builder()
                        .language("en")
                        .location("true")
                        .build())
                .body(XunFeiHandwritingRequestBody.builder()
                        .image(image)
                        .build())
                .mediaType(MediaType.APPLICATION_FORM_URLENCODED)
                .build();

        XunFeiHandwritingResponse operator = null;
        try {
            operator = xClient.operator(request, XunFeiHandwritingResponse.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return operator;
    }


    @RequestMapping("/xfVoice")
    public XunFeiVoiceResponse xfVoice(MultipartFile file) throws IOException {
        String image = new String(Base64.encodeBase64(file.getBytes()));

        XunFeiVoiceRequest request = XunFeiVoiceRequest.builder()
                .query(XunFeiVoiceRequestQuery.builder()
                        .aue("raw")
                        .result_level("simple")
                        .language("zh_cn")
                        .category("read_sentence")
                        .build())
                .body(XunFeiVoiceRequestBody.builder()
                        .audio(image)
                        .text("人之初,性本善,性相近,习相远.")
                        .build())
                .mediaType(MediaType.APPLICATION_FORM_URLENCODED)
                .build();

        XunFeiVoiceResponse operator = xVoiceClient.operator(request, XunFeiVoiceResponse.class);

        return operator;
    }


}
