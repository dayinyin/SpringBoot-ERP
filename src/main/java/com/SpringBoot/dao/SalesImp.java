package com.SpringBoot.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Sales;

@Mapper
public interface SalesImp {

	public List<Sales> select(@Param("customerid")Integer customerid,@Param("goodsid")Integer goodsid,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void insert(@Param("customerid")Integer customerid,@Param("paytype")String paytype,@Param("salestime")Date salestime,@Param("operateperson")String operateperson,
			@Param("number")Integer number,@Param("remark")String remark,@Param("saleprice")Double saleprice,@Param("goodsid")Integer goodsid);
	
	public void update(@Param("id")Integer id,@Param("customerid")Integer customerid,@Param("paytype")String paytype,@Param("salestime")Date salestime,@Param("operateperson")String operateperson,
			@Param("number")Integer number,@Param("remark")String remark,@Param("saleprice")Double saleprice,@Param("goodsid")Integer goodsid);
	
	public void delete(Integer id);
	
	public Sales selectById(Integer id);
	
	public void updateNumber(@Param("id")Integer id,@Param("number")Integer number);
}
