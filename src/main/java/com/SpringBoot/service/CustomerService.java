package com.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Customer;
import com.SpringBoot.dao.CustomerImp;


@Service
public class CustomerService implements CustomerImp{

	@Autowired
	CustomerImp customerImp;

	@Override
	public List<Customer> select(String customername,String connectionpersion,String phone,Integer index, Integer limit) {
		List<Customer> select = customerImp.select(customername, connectionpersion, phone, index, limit);
		return select;
	}

	@Override
	public List<Customer> selectName() {
		// TODO 自动生成的方法存根
		List<Customer> selectName = customerImp.selectName();
		return selectName;
	}

	@Override
	public void insert(String customername, String zip, String address, String telephone, String connectionpersion,
			String phone, String bank, String account, String email, String fax, Integer available) {
		// TODO 自动生成的方法存根
		customerImp.insert(customername, zip, address, telephone, connectionpersion, phone, bank, account, email, fax, available);
	}

	@Override
	public void update(Integer id, String customername, String zip, String address, String telephone,
			String connectionpersion, String phone, String bank, String account, String email, String fax,
			Integer available) {
		// TODO 自动生成的方法存根
		customerImp.update(id, customername, zip, address, telephone, connectionpersion, phone, bank, account, email, fax, available);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO 自动生成的方法存根
		customerImp.delete(id);
	}
	
}
