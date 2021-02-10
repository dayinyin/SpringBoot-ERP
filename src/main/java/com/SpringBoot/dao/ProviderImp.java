package com.SpringBoot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Provider;

@Mapper
public interface ProviderImp {

	public List<Provider> select(@Param("providername")String providername,@Param("connectionperson")String connectionperson,@Param("phone")String phone,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void insert(@Param("providername")String providername,@Param("zip")String zip,@Param("address")String address,@Param("telephone")String telephone,@Param("connectionperson")String connectionperson,
			@Param("phone")String phone,@Param("bank")String bank,@Param("account")String account,@Param("email")String email,@Param("fax")String fax,@Param("available")Integer available);
	
	public void update(@Param("id")Integer id,@Param("providername")String providername,@Param("zip")String zip,@Param("address")String address,@Param("telephone")String telephone,@Param("connectionperson")String connectionperson,
			@Param("phone")String phone,@Param("bank")String bank,@Param("account")String account,@Param("email")String email,@Param("fax")String fax,@Param("available")Integer available);
	
	public void delete(Integer id);
	
	public List<Provider> selectAvailable();
}
