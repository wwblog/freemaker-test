package com.xcw.freemarker.demo;

import com.alibaba.fastjson.JSONObject;
import com.xcw.freemarker.demo.app.api.provide.AppEmp1001v1Request;
import com.xcw.freemarker.demo.app.api.provide.AppEmp1001v1RequestData;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
@Log4j2
class FreemarkerDemoApplicationTests {

    @Test
    void contextLoads() {
        String body = "{\"data\": {\"page" +
                "\":\"1\"" +
                "}}";
        AppEmp1001v1Request req = JSONObject.parseObject(body, AppEmp1001v1Request.class);

        log.info("转换成为{}", req);
        log.info("转换成为{}", JSONObject.toJSON(AppEmp1001v1Request.builder().data(AppEmp1001v1RequestData.builder().build()).build()));

    }

    @Test
    void staremTesy() {
        List<String> list = new ArrayList(Arrays.asList("1", "2", "3", "4"));

        List<String> collect = list.stream().filter(l -> "2".equals(l)).collect(Collectors.toList());

        System.out.println(collect.toString() + "===========================================");

    }

    @Test
    void randomText() {
        String a = RandomStringUtils.random(5);//随机字符
        String b = RandomStringUtils.randomAlphabetic(5);//随机字符：字母
        String c = RandomStringUtils.randomNumeric(5);//随机字符：数字
        String d = RandomStringUtils.randomAlphanumeric(5);//随机字符：字母+数字
        log.info("a={},b={},c={}，d={}", a, b, c, d);
    }

    @Test
    void timeTest() {
        DateTime dateTime = DateTime.now().toDateTime();
        //转换日期
        Date d = dateTime.toDate();
        //转换为日历
        Calendar calendar = dateTime.toCalendar(Locale.CHINESE);
        log.info("joda时间{}======{}", d, calendar);
        String date = dateTime.toString("yyyy/MM/dd hh:mm:ss");

        log.info("util时间{}", date);
    }



}
