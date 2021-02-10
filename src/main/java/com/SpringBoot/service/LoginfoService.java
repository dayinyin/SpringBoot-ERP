package com.SpringBoot.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Loginfo;
import com.SpringBoot.dao.LoginfoImp;

@Service
public class LoginfoService {

	@Autowired
	LoginfoImp loginfoImp;
	
	public List<Loginfo> select(String loginname, String loginip
			,Integer index,Integer limit) {
		
		List<Loginfo> select = loginfoImp.select(loginname, loginip, index, limit);
		return select;
	}

	public void insert(String loginname, String loginip, Date logintime) {
		loginfoImp.insert(loginname, loginip, logintime);
	}

	public void delete(Integer id) {
		
		loginfoImp.delete(id);
	}
	

}
