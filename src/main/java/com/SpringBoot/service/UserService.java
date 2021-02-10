package com.SpringBoot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.User;
import com.SpringBoot.dao.UserImp;

@Service
public class UserService implements UserImp {

	@Autowired
	UserImp userImp;
	
	public User select(String loginname) {
		User user = userImp.select(loginname);
		return user;
	}

	@Override
	public List<User> selectAll(Integer deptid,String deptname, String name, String address,Integer index,Integer limit) {
		 List<User> selectAll = userImp.selectAll(deptid,deptname, name, address, index, limit);
		return selectAll;
	}

	@Override
	public void insert(String loginname,Integer ordernum, Integer available, Integer mgr, Date hiredate, String remark, Integer sex
			, Integer deptid, String name, String address) {
		userImp.insert(loginname,ordernum, available, mgr, hiredate, remark, sex, deptid, name, address);		
	}

	@Override
	public void update(Integer id, String loginname, Integer ordernum, Integer available, Integer mgr, Date hiredate,
			String remark, Integer sex, Integer deptid, String name, String address) {
		userImp.update(id, loginname, ordernum, available, mgr, hiredate, remark, sex, deptid, name, address);
		
	}

	@Override
	public void delete(Integer id) {
		userImp.delete(id);		
	}

	@Override
	public void resetPwd(Integer id) {
		userImp.resetPwd(id);
		
	}

	@Override
	public List<User> selectByDeptId(Integer deptId) {
		// TODO 自动生成的方法存根
		List<User> selectByDeptId = userImp.selectByDeptId(deptId);
		return selectByDeptId;
	}

	@Override
	public List<User> selectByMgr(Integer mgr) {
		// TODO 自动生成的方法存根
		List<User> selectByMgr = userImp.selectByMgr(mgr);
		return selectByMgr;
	}

}
