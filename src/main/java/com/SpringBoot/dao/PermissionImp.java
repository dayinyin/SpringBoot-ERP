package com.SpringBoot.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBoot.bean.Permission;

@Mapper
public interface PermissionImp {

	public List<Permission> selectAll();
	
	public List<Permission> selectPid(Integer pid);
	
	public List<Permission> selectmenu();
	
	public List<Permission> selectPermission();
	
	public List<Permission> select(@Param("title")String title,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public List<Permission> select2(@Param("percode")String percode,@Param("title")String title,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void insert(@Param("pid")Integer pid,@Param("title")String title,@Param("icon")String icon,@Param("href")String href
			,@Param("target")String target,@Param("open")Integer open,@Param("ordernum")Integer ordernum,@Param("available")Integer available);
	
	public void delete(Integer id);
	
	public void update(@Param("id")Integer id,@Param("pid")Integer pid,@Param("title")String title,@Param("icon")String icon,@Param("href")String href
			,@Param("target")String target,@Param("open")Integer open,@Param("ordernum")Integer ordernum,@Param("available")Integer available);
	
	public void insert2(@Param("pid")Integer pid,@Param("title")String title, @Param("percode")String percode, @Param("open")Integer open,
			@Param("ordernum")Integer ordernum, @Param("available")Integer available);
	
}
