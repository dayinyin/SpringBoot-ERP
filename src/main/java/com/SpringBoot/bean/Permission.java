package com.SpringBoot.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * InnoDB free: 9216 kB
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Permission  {

    private Integer id;

    private Integer pid;

    private String type;

    private String title;

    /**
     * 权限编码[只有type=permission才有 user:view]
     */
    private String percode;

    private String icon;

    private String href;

    private String target;

    private Integer open;

    private Integer ordernum;

    /**
     * 是否可用[0不可用，1可用]
     */
    private Integer available;
    
    private String ptitle;
}
