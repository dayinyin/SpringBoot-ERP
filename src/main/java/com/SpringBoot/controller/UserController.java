package com.SpringBoot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.common.DataGridView;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.SpringBoot.bean.User;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	LayuiJson layuiJson;
	
	
	   /**
     * 用户全查询
     */
    @RequestMapping("loadAllUser")
    public LayuiJson<User> select(Integer deptid,String deptname, String name, String address,Integer page,Integer limit){
    	
    	int index=(page-1)*limit;
    	List<User> data= userService.selectAll(deptid,deptname, name, address, index, limit);
    	layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);

		return layuiJson;
        
    }

    /**
     * 根据部门ID查询用户
     */
    @RequestMapping("loadUsersByDeptId")
    public DataGridView loadUsersByDeptId(Integer deptId) {
    	List<User> list = userService.selectByDeptId(deptId);
        return new DataGridView(list);
    }


    /**
     * 添加用户
     */
    
    @RequestMapping("addUser")
    public ResultObj addUser(String loginname,Integer ordernum, Integer available, Integer mgr,  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")Date hiredate, String remark, Integer sex,
			Integer deptid, String name, String address) {
        try {
        	userService.insert(loginname, ordernum, available, mgr, hiredate, remark, sex, deptid, name, address);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    

    /**
     * 找领导
     */
    @RequestMapping("queryMgrByUserId")
    public Map<String, Boolean> queryMgrByUserId(Integer id) {
    	Map<String, Boolean> map = new HashMap<String, Boolean>();
    	List<User> list = userService.selectByMgr(id);
    	if (list.size() > 0) {
            map.put("value", true);
        } else {
            map.put("value", false);
        }
        return map;
    }

    /**
     * 修改用户
     */
    @RequestMapping("updateUser")
    public ResultObj updateUser(Integer id,String loginname,Integer ordernum, Integer available, Integer mgr, Date hiredate, String remark, Integer sex
			, Integer deptid, String name, String address) {
        try {
        	userService.update(id, loginname, ordernum, available, mgr, hiredate, remark, sex, deptid, name, address);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除用户
     */
    @RequestMapping("deleteUser/{id}")
    public ResultObj deleteUser(@PathVariable(value = "id")Integer id) {
        try {
            this.userService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 重置用户密码
     */
    @RequestMapping("resetPwd/{id}")
    public ResultObj resetPwd(@PathVariable(value = "id")Integer id) {
        try {
        	userService.resetPwd(id);
            return ResultObj.RESET_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESET_ERROR;
        }
    }



}
