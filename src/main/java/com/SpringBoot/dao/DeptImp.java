package com.SpringBoot.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Dept;


@Mapper
public interface DeptImp {
	
	public List<Dept> selectAll();

	public List<Dept> select(@Param("name")String name,@Param("address")String address
			,@Param("remark")String remark,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void insert(@Param("pid")Integer pid,@Param("name")String name,@Param("open")Integer open,@Param("remark")String remark,@Param("address")String address,@Param("available")Integer available,@Param("ordernum")Integer ordernum,@Param("createtime")Date createtime);
	
	public void update(@Param("id")Integer id,@Param("pid")Integer pid,@Param("name")String name,@Param("open")Integer open,@Param("remark")String remark,@Param("address")String address,@Param("available")Integer available,@Param("ordernum")Integer ordernum);
	
	public void delete(Integer id);
	
	public Dept selectById(Integer id);
	
	public List<Dept> selectByPid(Integer pid);
}
