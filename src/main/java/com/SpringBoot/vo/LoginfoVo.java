package com.SpringBoot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import com.SpringBoot.bean.Loginfo;

import java.util.Date;

/**
 * @Author: 落亦-
 * @Date: 2019/11/23 18:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginfoVo extends Loginfo {

    private Integer page=1;
    private Integer limit=10;

    //接收多个id
    private Integer[] ids;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
