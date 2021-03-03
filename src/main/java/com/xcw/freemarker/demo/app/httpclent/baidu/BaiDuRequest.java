package com.xcw.freemarker.demo.app.httpclent.baidu;

import com.xcw.freemarker.demo.app.httpclent.BaseRequest;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

/**
 * @Author xcw
 * @Date 2021/3/1 12:22
 * @Description 描述
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BaiDuRequest extends BaseRequest<BaiDuRequestQuery,BaiDuRequestBody> {

    @Override
    protected String uri() {
        StringBuilder uri = new StringBuilder("");
        TypeAlias t = this.getClass().getAnnotation(TypeAlias.class);
        uri.append(t.value());
        return uri.toString();
    }
}
