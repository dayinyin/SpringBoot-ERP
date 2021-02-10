package com.SpringBoot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Dept;
import com.SpringBoot.common.DataGridView;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.common.TreeNode;
import com.SpringBoot.service.DeptService;
import com.SpringBoot.vo.DeptVo;

@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;
    
	@Autowired
	LayuiJson layuiJson;
	

    /**
     * 加载部门左边的菜单树
     * @param deptVo
     * @return
     */
	@RequestMapping("loadDeptManagerLeftTreeJson")
    public DataGridView loadManagerLeftTreeJson(){
        //查询出所有的部门，存放进list中
        List<Dept> list = deptService.selectAll();

        List<TreeNode> treeNodes = new ArrayList<>();
        //将部门放入treeNodes中，组装成json
        for (Dept dept : list) {
            Boolean open = dept.getOpen()==1?true:false;
            treeNodes.add(new TreeNode(dept.getId(),dept.getPid(),dept.getName(),open));
        }
        return new DataGridView(treeNodes);
    }

    /**
     * 查询所有部门数据
     * @param deptVo
     * @return
     */
    @RequestMapping("loadAllDept")
    public LayuiJson<Dept> select(String name,String address,String remark
    		,Integer page,Integer limit){
    	
    	int index=(page-1)*limit;
		List<Dept> data = deptService.select(name, address, remark, index, limit);
		layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);
		return layuiJson;
		
	}

    /**
     * 添加部门
     * @param deptVo
     * @return
     */
    @RequestMapping("addDept")
    public ResultObj addDept(Integer pid, String name, Integer open, String remark, String address, Integer available,
			Integer ordernum){
        try {
            Date createtime=new Date();
			deptService.insert(pid, name, open, remark, address, available, ordernum, createtime);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }


    /**
     * 更新部门
     * @param deptVo
     * @return
     */
    @RequestMapping("updateDept")
    public ResultObj updateDept(Integer id, Integer pid, String name, Integer open, String remark, String address,
			Integer available, Integer ordernum){
        try {
            deptService.update(id, pid, name, open, remark, address, available, ordernum);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 检查当前部门是否有子部门
     * @param deptVo
     * @return
     */
    @RequestMapping("checkDeptHasChildrenNode")
    public Map<String, Boolean> checkDeptHasChildrenNode(Integer id){
    	Map<String, Boolean> map = new HashMap<String, Boolean>();
    	List<Dept> list = deptService.selectByPid(id);
         if (list.size() > 0) {
             map.put("value", true);
         } else {
             map.put("value", false);
         }
         return map;
    }

    /**
     * 删除部门
     * @param deptVo
     * @return
     */
    @RequestMapping("deleteDept")
    public ResultObj deleteDept(Integer id){
        try {
            deptService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}

