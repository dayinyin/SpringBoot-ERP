package com.SpringBoot.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Notice {

	private Integer id;

    private String title;

    private String content;

    private Date createtime;

    private String opername;

	
}
