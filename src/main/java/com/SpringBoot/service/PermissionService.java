package com.SpringBoot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Permission;
import com.SpringBoot.dao.PermissionImp;

@Service
public class PermissionService implements PermissionImp{

	@Autowired
	PermissionImp permissionImp;

	@Override
	public List<Permission> selectmenu() {
		List<Permission> selectmenu = permissionImp.selectmenu();
		return selectmenu;
	}

	@Override
	public List<Permission> selectAll() {
		List<Permission> select = permissionImp.selectAll();
		return select;
	}

	@Override
	public List<Permission> select(String title,Integer index,Integer limit) {
		// TODO 自动生成的方法存根
		List<Permission> select = permissionImp.select(title,index, limit);
		return select;
	}
	
	@Override
	public List<Permission> select2(String percode,String title,Integer index,Integer limit) {
		// TODO 自动生成的方法存根
		List<Permission> select = permissionImp.select2(percode,title,index, limit);
		return select;
	}

	@Override
	public void insert(Integer pid, String title, String icon, String href, String target, Integer open,
			Integer ordernum, Integer available) {
		// TODO 自动生成的方法存根
		permissionImp.insert(pid, title, icon, href, target, open, ordernum, available);
	}

	@Override
	public void delete(Integer id) {
		// TODO 自动生成的方法存根
		permissionImp.delete(id);
	}

	@Override
	public void update(Integer id, Integer pid, String title, String icon, String href, String target, Integer open,
			Integer ordernum, Integer available) {
		// TODO 自动生成的方法存根
		permissionImp.update(id, pid, title, icon, href, target, open, ordernum, available);
	}

	@Override
	public List<Permission> selectPermission() {
		// TODO 自动生成的方法存根
		List<Permission> selectPermission = permissionImp.selectPermission();
		return selectPermission;
	}

	@Override
	public void insert2(Integer pid,String title, String percode, Integer open,
			Integer ordernum, Integer available) {
		// TODO 自动生成的方法存根
		permissionImp.insert2(pid, title, percode, open, ordernum, available);
	}

	@Override
	public List<Permission> selectPid(Integer pid) {
		// TODO 自动生成的方法存根
		List<Permission> selectPid = permissionImp.selectPid(pid);
		return selectPid;
	}
	
}
