package com.xcw.freemarker.demo.app.api.provide;

import com.xcw.freemarker.demo.app.api.vo.EmpAndEmpJobVo;
import com.xcw.freemarker.demo.app.api.vo.EmpVo;
import com.xcw.freemarker.demo.app.base.AppResponseData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/18 15:22
 * @Description 描述
 */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class AppEmp1003v1Response extends AppResponseData {
    /**
     * 返回信息
     */
    private List<EmpAndEmpJobVo> data;

    String code;

    String message;

    Boolean success = Boolean.FALSE;

}
