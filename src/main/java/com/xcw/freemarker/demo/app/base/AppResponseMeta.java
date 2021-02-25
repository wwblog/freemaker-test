package com.xcw.freemarker.demo.app.base;

/**
 * @Author xcw
 * @Date 2021/1/18 18:25
 * @Description 描述
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
public class AppResponseMeta {

    String code = "";

    String message ="";

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "UTC")
    Date time;

    Boolean success = Boolean.FALSE;

}
