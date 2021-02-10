package com.SpringBoot.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * InnoDB free: 9216 kB
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Role  {

    private Integer id;

    private String name;

    private String remark;

    /**
     * 0不可用，1可用
     */
    private Integer available;

    private Date createtime;


}
