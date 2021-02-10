package com.SpringBoot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Sales;
import com.SpringBoot.dao.SalesImp;

@Service
public class SalesService implements SalesImp {
	
	@Autowired
	SalesImp salesImp;
	
	@Override
	public List<Sales> select(Integer customerid, Integer goodsid, Integer index, Integer limit) {
		// TODO 自动生成的方法存根
		List<Sales> select = salesImp.select(customerid, goodsid, index, limit);
		return select;
	}

	@Override
	public void insert(Integer customerid, String paytype, Date salestime, String operateperson, Integer number,
			String remark, Double saleprice, Integer goodsid) {
		// TODO 自动生成的方法存根
		salesImp.insert(customerid, paytype, salestime, operateperson, number, remark, saleprice, goodsid);
	}

	@Override
	public void update(Integer id, Integer customerid, String paytype, Date salestime, String operateperson,
			Integer number, String remark, Double saleprice, Integer goodsid) {
		// TODO 自动生成的方法存根
		salesImp.update(id, customerid, paytype, salestime, operateperson, number, remark, saleprice, goodsid);
	}

	@Override
	public void delete(Integer id) {
		// TODO 自动生成的方法存根
		salesImp.delete(id);
	}

	@Override
	public Sales selectById(Integer id) {
		// TODO 自动生成的方法存根
		return salesImp.selectById(id);
	}

	@Override
	public void updateNumber(Integer id, Integer number) {
		// TODO 自动生成的方法存根
		salesImp.updateNumber(id, number);
	}


}
