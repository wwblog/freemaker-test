package com.xcw.freemarker.demo.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author xcw
 * @Date 2021/1/14 18:54
 * @Description 雇员职业类型表
 */
@Data
@Entity
@Table(name = "person_job")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpJobEntity implements Serializable {

    @Id
    private String uId;

    private String jobName;


}
