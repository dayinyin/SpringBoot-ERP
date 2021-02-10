package com.SpringBoot.vo;

import java.util.Date;

import com.SpringBoot.bean.Dept;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 落亦-
 * @Date: 2019/11/26 11:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptVo extends Dept {

    private Integer page=1;
    private Integer limit=10;

}
