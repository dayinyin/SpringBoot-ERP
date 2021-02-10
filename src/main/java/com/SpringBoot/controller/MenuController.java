package com.SpringBoot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Dept;
import com.SpringBoot.bean.Loginfo;
import com.SpringBoot.bean.Permission;
import com.SpringBoot.bean.User;
import com.SpringBoot.common.Constast;
import com.SpringBoot.common.DataGridView;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.common.TreeNode;
import com.SpringBoot.common.TreeNodeBuilder;
import com.SpringBoot.common.WebUtils;
import com.SpringBoot.service.PermissionService;
import com.SpringBoot.vo.PermissionVo;


@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;


    @Autowired
    HttpSession httpSession;
    
    @Autowired
   	LayuiJson layuiJson;
    
    @RequestMapping("loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo){
        //查询所有菜单
    	 List<Permission> list = null;
         if (httpSession.getAttribute("type").equals(Constast.USER_TYPE_SUPER)){
             //用户类型为超级管理员
             list = permissionService.selectmenu();
         }else {
        	 
             list = permissionService.selectmenu();

         }

        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (Permission p : list) {
            Integer id =p.getId();
            Integer pid = p.getPid();
            String title = p.getTitle();
            String icon = p.getIcon();
            String href = p.getHref();
            Boolean spread = p.getOpen().equals(Constast.OPEN_TRUE)?true:false;
            treeNodes.add(new TreeNode(id,pid,title,icon,href,spread));
        }

        //构造层级关系
        List<TreeNode> list2 = TreeNodeBuilder.build(treeNodes,1);
        return new DataGridView(list2);

    }
    
    
    /************************菜单管理*********************************/

    /**
     * 加载菜单左边的菜单树
     * @param permissionVo
     * @return
     */
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(PermissionVo permissionVo){
        //查询出所有的菜单，存放进list中
        List<Permission> list = permissionService.selectmenu();
        List<TreeNode> treeNodes = new ArrayList<>();
        //将菜单放入treeNodes中，组装成json
        for (Permission menu : list) {
            Boolean open = menu.getOpen()==1?true:false;
            treeNodes.add(new TreeNode(menu.getId(),menu.getPid(),menu.getTitle(),open));
        }
        return new DataGridView(treeNodes);
    }

    /**
     * 查询所有菜单数据
     * @param permissionVo
     * @return
     */
    @RequestMapping("loadAllMenu")
    public LayuiJson<Permission> loadAllMenu(String title,Integer page,Integer limit){
    	int index=(page-1)*limit;
    	List<Permission> data = permissionService.select(title, index, limit);
    	layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);

		return layuiJson;
    }

    /**
     * 添加菜单
     * @param permissionVo
     * @return
     */
    @RequestMapping("addMenu")
    public ResultObj addMenu(Integer pid, String title, String icon, String href, String target, Integer open,
			Integer ordernum, Integer available){
        try {
            //设置添加类型为 menu
            permissionService.insert(pid, title, icon, href, target, open, ordernum, available);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 更新菜单
     * @param permissionVo
     * @return
     */
    @RequestMapping("updateMenu")
    public ResultObj updateMenu(Integer id,Integer pid, String title, String icon, String href, String target, Integer open,
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
     * 检查当前菜单是否有子菜单
     * @param permissionVo
     * @return
     */
    @RequestMapping("checkMenuHasChildrenNode")
    public Map<String,Boolean> checkMenuHasChildrenNode(Integer id){
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
     * 删除菜单
     * @param permissionVo
     * @return
     */
    @RequestMapping("deleteMenu")
    public ResultObj deleteMenu(Integer id){
        try {
            permissionService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    
}
