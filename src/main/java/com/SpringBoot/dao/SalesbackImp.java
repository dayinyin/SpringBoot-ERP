package com.SpringBoot.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Salesback;

@Mapper
public interface SalesbackImp {

	public List<Salesback> select(@Param("customerid")Integer customerid,@Param("goodsid")Integer goodsid,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void delete(Integer id);
	
	public void insert(@Param("customerid")Integer customerid,@Param("paytype")String paytype,@Param("salesbacktime")Date salesbacktime,
			@Param("salebackprice")Double salebackprice,@Param("operateperson")String operateperson,
			@Param("number")Integer number,@Param("remark")String remark,@Param("goodsid")Integer goodsid);
}
