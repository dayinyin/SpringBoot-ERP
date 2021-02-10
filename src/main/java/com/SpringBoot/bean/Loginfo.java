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
public class Loginfo {	

	private Integer id;

    private String loginname;

    private String loginip;

    private Date logintime;
	
}
