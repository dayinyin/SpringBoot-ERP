package com.SpringBoot.vo;

import com.SpringBoot.bean.Permission;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 落亦-
 * @Date: 2019/11/22 15:30
 */
@Data
public class PermissionVo extends Permission {

    private Integer page=1;
    private Integer limit=10;
}
