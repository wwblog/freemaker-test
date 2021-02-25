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
 * @Description 雇员基本信息表
 */
@Data
@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    private String id;

    private String uId;

    private String uaaId;


    private String psWord;

    private String userName;


}
