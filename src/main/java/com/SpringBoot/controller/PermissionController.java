package com.SpringBoot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Permission;
import com.SpringBoot.common.DataGridView;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.common.TreeNode;
import com.SpringBoot.service.PermissionService;


@RestController
@RequestMapping("permission")
public class PermissionController {
    
    @Autowired
    private PermissionService permissionService;
    
    @Autowired
   	LayuiJson layuiJson;

    /**
     * 加载权限左边的权限树
     * @param permissionVo
     * @return
     */
    @RequestMapping("loadPermissionManagerLeftTreeJson")
    public DataGridView loadPermissionManagerLeftTreeJson(){
        //查询出所有的权限，存放进list中
        List<Permission> list = permissionService.selectAll();
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        //将权限放入treeNodes中，组装成json
        for (Permission permission : list) {
        	Boolean open = permission.getOpen()==1?true:false;
            treeNodes.add(new TreeNode(permission.getId(),permission.getPid(),permission.getTitle(),open));
        }
        return new DataGridView(treeNodes);
    }

    /**
     * 查询所有权限数据
     * @param permissionVo
     * @return
     */
    @RequestMapping("loadAllPermission")
    public LayuiJson<Permission> loadAllPermission(String percode,String title,Integer page,Integer limit){
    	int index=(page-1)*limit;
    	List<Permission> data = permissionService.select2(percode,title, index, limit);
    	layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);

		return layuiJson;
    }

    /**
     * 添加权限
     * @param permissionVo
     * @return
     */
    @RequestMapping("addPermission")
    public ResultObj addPermission(Integer pid,String title, String percode, Integer open,
			Integer ordernum, Integer available){
        try {
            permissionService.insert2(pid, title, percode, open, ordernum, available);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }


    /**
     * 更新权限
     * @param permissionVo
     * @return
     */
    @RequestMapping("updatePermission")
    public ResultObj updatePermission(Integer id,Integer pid, String title, String icon, String href, String target, Integer open,
			Integer ordernum, Integer available){
        try {
            permissionService.update(id, pid, title, icon, href, target, open, ordernum, available);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 检查当前权限是否有子权限
     * @param permissionVo
     * @return
     */
    @RequestMapping("checkPermissionHasChildrenNode")
    public Map<String,Boolean> checkPermissionHasChildrenNode(Integer id){
    	Map<String, Boolean> map = new HashMap<String, Boolean>();
    	List<Permission> list = permissionService.selectPid(id);
         if (list.size() > 0) {
             map.put("value", true);
         } else {
             map.put("value", false);
         }
         return map;
    }

    /**
     * 删除权限
     * @param permissionVo
     * @return
     */
    @RequestMapping("deletePermission")
    public ResultObj deletePermission(Integer id){
        try {
            permissionService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    
}

