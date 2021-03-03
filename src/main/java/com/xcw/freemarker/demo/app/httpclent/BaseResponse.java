package com.xcw.freemarker.demo.app.httpclent;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @Author xcw
 * @Date 2021/3/2 9:56
 * @Description 描述
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class BaseResponse<T>  implements Serializable {
    T data;
}
