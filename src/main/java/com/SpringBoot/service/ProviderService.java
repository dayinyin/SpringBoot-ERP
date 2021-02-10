package com.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Provider;
import com.SpringBoot.dao.ProviderImp;

@Service
public class ProviderService implements ProviderImp {

	@Autowired
	ProviderImp providerImp;
	
	@Override
	public void insert(String providername, String zip, String address, String telephone, String connectionperson,
			String phone, String bank, String account, String email, String fax, Integer available) {
		providerImp.insert(providername, zip, address, telephone, connectionperson, phone, bank, account, email, fax, available);
	}

	@Override
	public void update(Integer id, String providername, String zip, String address, String telephone,
			String connectionperson, String phone, String bank, String account, String email, String fax,
			Integer available) {
		providerImp.update(id, providername, zip, address, telephone, connectionperson, phone, bank, account, email, fax, available);		
	}

	@Override
	public void delete(Integer id) {
		providerImp.delete(id);		
	}

	@Override
	public List<Provider> select(String providername, String connectionperson, String phone, Integer index,
			Integer limit) {
		List<Provider> select = providerImp.select(providername, connectionperson, phone, index, limit);
		return select;
	}

	@Override
	public List<Provider> selectAvailable() {
		// TODO 自动生成的方法存根
		List<Provider> selectAvailable = providerImp.selectAvailable();
		return selectAvailable;
	}

}
