package com.xcw.freemarker.demo.app.mapper;

import com.alibaba.fastjson.JSONObject;
import com.querydsl.core.types.Projections;
import com.xcw.freemarker.demo.app.entity.EmpAndEmpJobDo;
import com.xcw.freemarker.demo.app.entity.EmpEntity;
import com.xcw.freemarker.demo.app.entity.QEmpEntity;
import com.xcw.freemarker.demo.app.entity.QEmpJobEntity;
import com.xcw.freemarker.demo.app.repository.EmpConvertor;
import com.xcw.freemarker.demo.app.repository.EmpRepository;
import com.xcw.freemarker.demo.app.vo.EmpVO;
import com.xcw.freemarker.demo.core.db.QueryDslEntityManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @Author xcw
 * @Date 2021/1/19 12:08
 * @Description emp数据访问层
 */
@Component
@Log4j2
public class EmpMapper extends QueryDslEntityManager {
    @Autowired
    EmpRepository empRepository;

      @Autowired
      EmpConvertor convertor;


    /**
     * 根据uid查询所有雇员
     *
     * @param uId
     * @return
     */
    public List<EmpVO> findEmpEntityByUId(String uId) {
        // return convertor.to(empRepository.findEmpEntityByUId(uId));
        List<EmpEntity> list = empRepository.findEmpEntityByuId(uId);
        List<EmpVO> li = JSONObject.parseArray(JSONObject.toJSONString(list), EmpVO.class);
        return li;
    }

    /**
     * 查询所有emp记录
     */
    public List<EmpVO> findAll() {
        //return convertor.to(empRepository.findAll());
        Sort sort =Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Specification specification = (Specification<EmpVO>) (root, query, cb) -> {
            Path<Object> uaaId = root.get("uaaId");

            Predicate predicate = cb.equal(uaaId, "1");

            return cb.and(predicate);
        };

        Page<EmpEntity> list = empRepository.findAll(specification,pageable);
       // List<EmpVO> li = JSONObject.parseArray(JSONObject.toJSONString(list.getContent()), EmpVO.class);

        return convertor.toDomain(list.getContent());
    }


    /**
     * 根据username查询
     */
    public List<EmpVO> findEmpEntityByUserName(EmpVO vo) {
        // EmpEntity entity = convertor.from(vo);z
        // return convertor.to(empRepository.findEmpEntityByUserName(entity));
        EmpEntity entity = JSONObject.parseObject(JSONObject.toJSONString(vo), EmpEntity.class);

        List<EmpEntity> list = empRepository.findEmpEntityByUserName(entity);
        List<EmpVO> li = JSONObject.parseArray(JSONObject.toJSONString(list), EmpVO.class);
        return li;
    }

    /**
     * 查询所有emp对应的职业
     */
    public List<EmpAndEmpJobDo> findEmpAndEmpJob() {
        //雇员基本信息
        QEmpEntity empEntity = QEmpEntity.empEntity;
        //雇员职业类型表
        QEmpJobEntity empJobEntity = QEmpJobEntity.empJobEntity;

        List<EmpAndEmpJobDo> result = jpaQueryFactory
                .select(
                        Projections.bean(
                                EmpAndEmpJobDo.class,
                                empEntity.id,
                                empEntity.psWord,
                                empEntity.userName,
                                empEntity.uId,
                                empJobEntity.jobName
                        )

                ).from(empEntity, empJobEntity)
                .where(empEntity.uId.eq(empJobEntity.uId)).fetch();

        return result;
    }

}
