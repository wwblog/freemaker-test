package com.xcw.freemarker.demo.core.mapper;

import org.mapstruct.*;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/29 14:27
 * @Description 实体类转换基本接口
 */
public interface BaseMapstruct<Entity, Domain> {

    @Mappings({})
    @InheritConfiguration
    Entity toEntity(Domain domin);

    @InheritInverseConfiguration
    Domain toDomain(Entity entity);

    @InheritConfiguration
    List<Entity> toEntity(List<Domain> domin);

    @InheritInverseConfiguration
    List<Domain> toDomain(List<Entity> entity);

}
