package com.SpringBoot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Role;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	LayuiJson layuiJson;
	
	@RequestMapping("loadAllRole")
	public LayuiJson<Role> loadAllRole(String name,String remark,Integer available,Integer page,Integer limit){
		int index=(page-1)*limit;
		List<Role> data = roleService.select(name, remark, available, index, limit);
		layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);
		return layuiJson;

	 }
	
	@RequestMapping("addRole")
    public ResultObj addRole(String name, String remark, Integer available) {
        try {
            LocalDateTime createtime = LocalDateTime.now();
            roleService.insertRole(name, remark, available, createtime);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
	
	@RequestMapping("deleteRole")
	public ResultObj deleteRole(Integer id) {
        try {
        	roleService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
	
	@RequestMapping("updateRole")
	public ResultObj updateRole(Integer id,String name, String remark, Integer available) {
		try {
			LocalDateTime createtime = LocalDateTime.now();
        	roleService.updateRole(id, name, remark, available, createtime);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
	}
}