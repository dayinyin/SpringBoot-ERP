package com.SpringBoot.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Inport;

@Mapper
public interface InportImp {

	public List<Inport> select(@Param("providerid")Integer providerid,@Param("goodsid")Integer goodsid,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void insert(@Param("paytype")String paytype,@Param("inporttime")Date inporttime,@Param("operateperson")String operateperson,@Param("number")Integer number,@Param("remark")String remark
			,@Param("inportprice")Double inportprice,@Param("providerid")Integer providerid,@Param("goodsid")Integer goodsid);
	
	public void update (@Param("id")Integer id,@Param("paytype")String paytype,@Param("inporttime")Date inporttime,@Param("number")Integer number,@Param("remark")String remark
			,@Param("inportprice")Double inportprice,@Param("providerid")Integer providerid,@Param("goodsid")Integer goodsid,@Param("operateperson")String operateperson);
	
	public void delete(Integer id);
	
	public Inport selectById(Integer id);
	
}
