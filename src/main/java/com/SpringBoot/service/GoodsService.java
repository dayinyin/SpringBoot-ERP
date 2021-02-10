package com.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Goods;
import com.SpringBoot.dao.GoodsImp;

@Service
public class GoodsService implements GoodsImp {

	@Autowired
	GoodsImp goodsImp;
	
	
	@Override
	public void insert(Integer providerid, String goodsname, String productcode, String promitcode, String description,
			String size, String produceplace, String goodspackage, Double price, Integer number, Integer dangernum,
			Integer available) {
		goodsImp.insert(providerid, goodsname, productcode, promitcode, description, size, produceplace, goodspackage, price, number, dangernum, available);
	}

	@Override
	public void delete(Integer id) {
		goodsImp.delete(id);		
	}

	@Override
	public void update(Integer id, Integer providerid, String goodsname, String productcode, String promitcode,
			String description, String size, String produceplace, String goodspackage, Double price, Integer number,
			Integer dangernum, Integer available) {
		goodsImp.update(id, providerid, goodsname, productcode, promitcode, description, size, produceplace, goodspackage, price, number, dangernum, available);		
	}


	@Override
	public void updateNumber(Integer id, Integer number) {
		goodsImp.updateNumber(id, number);
		
	}

	@Override
	public List<Goods> select(Integer providerid, String goodsname, String productcode, String promitcode,
			String description, String size, Integer index, Integer limit) {
		// TODO 自动生成的方法存根
		List<Goods> select = goodsImp.select(providerid, goodsname, productcode, promitcode, description, size, index, limit);
		return select;
	}

	@Override
	public List<Goods> selectGoodsName() {
		// TODO 自动生成的方法存根
		List<Goods> selectGoodsName = goodsImp.selectGoodsName();
		return selectGoodsName;
	}

	@Override
	public List<Goods> selectByProviderid(Integer providerid) {
		// TODO 自动生成的方法存根
		return goodsImp.selectByProviderid(providerid);
	}

	@Override
	public Goods selectById(Integer id) {
		// TODO 自动生成的方法存根
		return goodsImp.selectById(id);
	}

	

}
