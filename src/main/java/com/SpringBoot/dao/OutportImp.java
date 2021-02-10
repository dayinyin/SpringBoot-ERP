package com.SpringBoot.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.SpringBoot.bean.Outport;

@Mapper
public interface OutportImp {

	public List<Outport> select(@Param("providerid")Integer providerid,@Param("goodsid")Integer goodsid,@Param("index")Integer index,@Param("limit")Integer limit);
	
	public void insert(@Param("paytype")String paytype,@Param("outputtime")Date outputtime,@Param("operateperson")String operateperson,@Param("number")Integer number,@Param("remark")String remark
			,@Param("outportprice")Double outportprice,@Param("providerid")Integer providerid,@Param("goodsid")Integer goodsid);
	
	public void delete(Integer id);
	
	public Outport selectID(Integer id);
}
