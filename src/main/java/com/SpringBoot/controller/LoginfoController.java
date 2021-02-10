package com.SpringBoot.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Loginfo;
import com.SpringBoot.common.DataGridView;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.service.LoginfoService;
import com.SpringBoot.vo.LoginfoVo;


@RestController
@RequestMapping("loginfo")
public class LoginfoController {

    @Autowired
    private LoginfoService loginfoService;
    
    @Autowired
	LayuiJson layuiJson;

    /**
     * 查询所有登陆日志的信息
     * @param loginfoVo
     * @return
     */
    @RequestMapping("loadAllLoginfo")
    public LayuiJson<Loginfo> loadAllLoginfo(String loginname,String loginip
    		,Integer page,Integer limit){
    	
    	int index=(page-1)*limit;
    	List<Loginfo> data= loginfoService.select(loginname, loginip, index, limit);
		layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);

		return layuiJson;
    }

    /**
     * 删除单条日志
     * @param id
     * @return
     */
    @RequestMapping("deleteLoginfo")
    public ResultObj deleteLoginfo(Integer id){
        try {
            loginfoService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     * @param loginfoVo
     * @return
     */
    @RequestMapping("batchDeleteLoginfo")
    public ResultObj batchDeleteLoginfo(LoginfoVo loginfoVo){
        try {
            List<Integer> idList = new ArrayList<Integer>();
            for (Integer id : loginfoVo.getIds()) {
                idList.add(id);
            }
            for(Integer id :idList) {
            	loginfoService.delete(id);
            }
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}

