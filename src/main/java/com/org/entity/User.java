package com.org.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
//@EqualsAndHashCode(callSuper = false)
public class User{
    @Id  //表面ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自动生成ID
    //private static final long serialVersionUID = 1L;

    //@TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String account;

    private String password;

    private String role;

}
