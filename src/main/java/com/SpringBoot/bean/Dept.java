package com.SpringBoot.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Dept {

    private Integer id;

    private Integer pid;

    private String name;

    /**
     * 是否展开，0不展开，1展开
     */
    private Integer open;

    private String remark;

    private String address;

    /**
     * 是否可用，0不可用，1可用
     */
    private Integer available;

    /**
     * 排序码
     */
    private Integer ordernum;

    private Date createtime;
    
    private String pname;


}
