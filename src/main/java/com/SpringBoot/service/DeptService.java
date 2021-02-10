package com.SpringBoot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Dept;
import com.SpringBoot.dao.DeptImp;

@Service
public class DeptService implements DeptImp {

	@Autowired
	DeptImp deptImp;
	
	@Override
	public List<Dept> select(String name, String address, String remark,Integer index,Integer limit) {
		List<Dept> Dept = deptImp.select(name, address, remark, index, limit);
		return Dept;
	}

	@Override
	public void insert(Integer pid, String name, Integer open, String remark, String address, Integer available,
			Integer ordernum, Date createtime) {
		deptImp.insert(pid, name, open, remark, address, available, ordernum, createtime);
	}

	@Override
	public void update(Integer id, Integer pid, String name, Integer open, String remark, String address,
			Integer available, Integer ordernum) {
		deptImp.update(id, pid, name, open, remark, address, available, ordernum);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO 自动生成的方法存根
		deptImp.delete(id);
	}

	@Override
	public List<Dept> selectAll() {
		List<Dept> selectAll = deptImp.selectAll();
		return selectAll;
	}

	@Override
	public Dept selectById(Integer id) {
		Dept selectById = deptImp.selectById(id);
		return selectById;
	}

	@Override
	public List<Dept> selectByPid(Integer pid) {
		// TODO 自动生成的方法存根
		List<Dept> selectByPid = deptImp.selectByPid(pid);
		return selectByPid;
	}

}
