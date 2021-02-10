package com.SpringBoot.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Loginfo;

@Mapper
public interface LoginfoImp {

	public List<Loginfo> select(@Param("loginname")String loginname,@Param("loginip")String loginip
			,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void insert(@Param("loginname")String loginname,@Param("loginip")String loginip,@Param("logintime")Date logintime);
	
	public void delete(Integer id);
}
