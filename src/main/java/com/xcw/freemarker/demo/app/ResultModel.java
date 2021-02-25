package com.xcw.freemarker.demo.app;

import lombok.*;

/**
 * @Author xcw
 * @Date 2021/2/5 9:54
 * @Description 返回值
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResultModel<T> {
    Integer code;
    Boolean success;
    String message;
    T data;
}
