package com.SpringBoot.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.SpringBoot.bean.Notice;

import lombok.Data;

/**
 * @Author: 落亦-
 * @Date: 2019/11/25 8:51
 */
@Data
public class NoticeVo extends Notice {

    //接受多个ID
    private Integer[] ids;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
