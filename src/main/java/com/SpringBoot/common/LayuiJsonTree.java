package com.SpringBoot.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.SpringBoot.bean.Loginfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LayuiJsonTree<T> implements Serializable{

	Integer code ;
	
	String msg;
	
	Integer count;
	
	List<T> data;

}
