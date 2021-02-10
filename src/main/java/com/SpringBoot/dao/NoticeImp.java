package com.SpringBoot.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Notice;

@Mapper
public interface NoticeImp {

	public List<Notice> select(@Param("title")String title,@Param("opername")String opername
			,@Param("index")Integer index,@Param("limit")Integer limit);	
	
	public void delect(Integer id);
	
	public void insert(@Param("title")String title,@Param("content")String content,@Param("createtime")Date createtime,@Param("opername")String opername);
	
	public void update(@Param("id")Integer id,@Param("content")String content);
	
	public Notice selectById(Integer id);
}
