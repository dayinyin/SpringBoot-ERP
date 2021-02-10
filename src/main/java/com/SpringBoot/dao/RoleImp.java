package com.SpringBoot.dao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Role;

@Mapper
public interface RoleImp {

	public List<Role> select(@Param("name")String name,@Param("remark")String remark,@Param("available")Integer available,
			@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void insertRole(@Param("name")String name ,@Param("remark")String remark,@Param("available")Integer available,
			@Param("createtime")LocalDateTime createtime);
	
	public void updateRole(@Param("id")Integer id,@Param("name")String name ,@Param("remark")String remark,@Param("available")Integer available,
			@Param("createtime")LocalDateTime createtime);
	
	public void delete(Integer id);
	
}
