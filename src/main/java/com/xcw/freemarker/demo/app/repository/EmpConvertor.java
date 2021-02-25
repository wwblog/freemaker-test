package com.xcw.freemarker.demo.app.repository;

import com.xcw.freemarker.demo.app.entity.EmpEntity;
import com.xcw.freemarker.demo.app.vo.EmpVO;
import com.xcw.freemarker.demo.core.mapper.BaseMapstruct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @Author xcw
 * @Date 2021/1/29 14:18
 * @Description 雇员转换类
 */
@Mapper(componentModel = "spring")
public interface EmpConvertor extends BaseMapstruct<EmpEntity, EmpVO> {


}
