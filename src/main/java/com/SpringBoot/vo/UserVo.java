package com.SpringBoot.vo;

import com.SpringBoot.bean.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo extends User {


    private Integer page = 1;
    private Integer limit = 10;

}