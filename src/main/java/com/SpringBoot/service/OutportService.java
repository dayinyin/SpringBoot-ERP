package com.SpringBoot.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Inport;
import com.SpringBoot.bean.Outport;
import com.SpringBoot.dao.OutportImp;

@Service
public class OutportService implements OutportImp {

	@Autowired
	OutportImp outportImp;
	
	@Override
	public void delete(Integer id) {
		outportImp.delete(id);
	}

	@Override
	public Outport selectID(Integer id) {
		Outport outport = outportImp.selectID(id);
		return outport;
	}

	@Override
	public List<Outport> select(Integer providerid, Integer goodsid, Integer index, Integer limit) {
		// TODO 自动生成的方法存根
		List<Outport> select = outportImp.select(providerid, goodsid, index, limit);
		return select;
	}

	@Override
	public void insert(String paytype, Date outputtime, String operateperson, Integer number, String remark,
			Double outportprice, Integer providerid, Integer goodsid) {
		// TODO 自动生成的方法存根
		outportImp.insert(paytype, outputtime, operateperson, number, remark, outportprice, providerid, goodsid);
	}

	

}
