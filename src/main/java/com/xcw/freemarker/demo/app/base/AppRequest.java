package com.xcw.freemarker.demo.app.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.util.MultiValueMap;

/**
 * @Author xcw
 * @Date 2021/1/18 11:51
 * @Description 入参类
 */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class AppRequest<D> {
    String traceId;

     D data;

    @JsonIgnore
    MultiValueMap<String, String> headers;

    @JsonIgnore
    MultiValueMap<String, String> queryValue;

    /**
     * 会员ID
     */
    @JsonIgnore
    String memberId;

    /**
     * 手机号
     */
    @JsonIgnore
    String mobile;

    @JsonIgnore
    String token;

    @JsonIgnore
    AppRequestPathValue pathValue;


}
