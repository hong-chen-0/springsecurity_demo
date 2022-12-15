package com.org.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 * 
 * </p>
 *
 * @author 刘文鑫
 * @since 2020-11-27
 */
@Data
@Entity
//@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {
    @Id  //表面ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自动生成ID
    //private static final long serialVersionUID = 1L;

    //@TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String account;

    private String password;

    private String role;

}
