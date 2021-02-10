package com.SpringBoot.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Role;
import com.SpringBoot.dao.RoleImp;

@Service
public class RoleService implements RoleImp{
	
	@Autowired
	RoleImp roleImp;

	@Override
	public List<Role> select(String name, String remark, Integer available, Integer index, Integer limit) {
		// TODO 自动生成的方法存根
		List<Role> select = roleImp.select(name, remark, available, index, limit);
		return select;
	}

	@Override
	public void insertRole(String name, String remark, Integer available, LocalDateTime createtime) {
		// TODO 自动生成的方法存根
		roleImp.insertRole(name, remark, available, createtime);
	}

	@Override
	public void updateRole(Integer id, String name, String remark, Integer available, LocalDateTime createtime) {
		// TODO 自动生成的方法存根
		roleImp.updateRole(id, name, remark, available, createtime);
	}

	@Override
	public void delete(Integer id) {
		// TODO 自动生成的方法存根
		roleImp.delete(id);
	}


	
}
