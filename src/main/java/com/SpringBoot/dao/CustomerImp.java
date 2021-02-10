package com.SpringBoot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Customer;

@Mapper
public interface CustomerImp {

	public List<Customer> select(@Param("customername")String customername,@Param("connectionpersion")String connectionpersion,@Param("phone")String phone,
			@Param("index")Integer index,@Param("limit")Integer limit);
	
	public List<Customer> selectName();
	
	public void insert(@Param("customername")String customername,@Param("zip")String zip,@Param("address")String address,@Param("telephone")String telephone,@Param("connectionpersion")String connectionpersion
			,@Param("phone")String phone,@Param("bank")String bank,@Param("account")String account
			,@Param("email")String email,@Param("fax")String fax,@Param("available")Integer available);
	
	public void update(@Param("id")Integer id,@Param("customername")String customername,@Param("zip")String zip,@Param("address")String address,@Param("telephone")String telephone,@Param("connectionpersion")String connectionpersion
			,@Param("phone")String phone,@Param("bank")String bank,@Param("account")String account
			,@Param("email")String email,@Param("fax")String fax,@Param("available")Integer available);
	
	public void delete(Integer id);
}
