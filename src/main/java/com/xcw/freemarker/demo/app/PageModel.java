package com.xcw.freemarker.demo.app;

import lombok.*;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/2/5 9:54
 * @Description 返回值
 */
@Data
public class PageModel<T> {
    long total;
    List<T> rows;
}
