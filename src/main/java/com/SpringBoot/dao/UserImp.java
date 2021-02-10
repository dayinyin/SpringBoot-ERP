package com.SpringBoot.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.User;

@Mapper
public interface UserImp {

	public User select(String loginname);
	
	public List<User> selectAll(@Param("deptid")Integer deptid,@Param("deptname")String deptname,@Param("name")String name,@Param("address")String address
				,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void insert(@Param("loginname")String loginname,@Param("ordernum")Integer ordernum,@Param("available")Integer available,@Param("mgr")Integer mgr
			,@Param("hiredate")Date hiredate,@Param("remark")String remark,@Param("sex")Integer sex,
			@Param("deptid")Integer deptid,@Param("name")String name,@Param("address")String address);
	
	public void update(@Param("id")Integer id,@Param("loginname")String loginname,@Param("ordernum")Integer ordernum,@Param("available")Integer available,@Param("mgr")Integer mgr
			,@Param("hiredate")Date hiredate,@Param("remark")String remark,@Param("sex")Integer sex,
			@Param("deptid")Integer deptid,@Param("name")String name,@Param("address")String address);
	
	public void delete(Integer id);
	
	public void resetPwd(Integer id);
	
	public List<User> selectByDeptId(Integer deptId);
	
	public List<User> selectByMgr(Integer mgr);
}
