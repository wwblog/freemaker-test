package com.xcw.freemarker.demo.app.repository;

import com.xcw.freemarker.demo.app.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/15 9:03
 * @Description emp表操作类
 */
@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, String>, QuerydslPredicateExecutor<EmpEntity>, JpaSpecificationExecutor<EmpEntity> {

    @Query(value = "SELECT * FROM person WHERE user_name like CONCAT('%',:#{#entity.userName},'%')", nativeQuery = true)
    public List<EmpEntity> findEmpEntityByUserName(EmpEntity entity);

    public List<EmpEntity> findEmpEntityByuId(String uId);
}
