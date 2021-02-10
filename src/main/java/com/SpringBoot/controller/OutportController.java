package com.SpringBoot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Inport;
import com.SpringBoot.bean.Outport;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.service.InportService;
import com.SpringBoot.service.OutportService;

@RestController
@RequestMapping("outport")
public class OutportController {
	
	@Autowired
	LayuiJson layuiJson;
	
	@Autowired
	OutportService outportService;
	
	@Autowired
	InportService inportService;
	
	@Autowired
	HttpSession httpSession;
	
	@RequestMapping("loadAllOutport")
	public LayuiJson<Outport> loadAllOutport(Integer providerid,Integer goodsid,Integer page,Integer limit){
		int index=(page-1)*limit;
		List<Outport> data = outportService.select(providerid, goodsid, index, limit);
		layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);
		return layuiJson;
	}
	
	/**
     * 删除退货信息
     * @param id
     * @return
     */
    @RequestMapping("deleteOutport")
    public ResultObj deleteOutport(Integer id){
        try {
            outportService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    /**
     * 添加退货信息
     * @param id    进货单ID
     * @param number    退货数量
     * @param remark    备注
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("addOutport")
    public ResultObj addOutport(Integer id,Integer number,String remark){
        try {
        	Inport i = inportService.selectById(id);
        	String paytype = i.getPaytype();
        	Integer goodsid = i.getGoodsid();
        	Double outportprice = i.getInportprice();
        	Integer providerid = i.getProviderid();
        	Date outputtime = new Date();
        	String operateperson = (String) httpSession.getAttribute("username");
    		
        	
        	if(i.getNumber()==number) {
        		
        		outportService.insert(paytype, outputtime, operateperson, number, 
        				remark, outportprice, providerid, goodsid);
        		inportService.delete(id);
                return ResultObj.BACKINPORT_SUCCESS;
        	}else if(i.getNumber()>number) {
        		
        		outportService.insert(paytype, outputtime, operateperson, number, 
        				remark, outportprice, providerid, goodsid);
        		
        		inportService.update(id, paytype, outputtime, i.getNumber()-number, i.getRemark(), outportprice
        				, providerid, goodsid, operateperson);
        		return ResultObj.BACKINPORT_SUCCESS;
        		
        	}else {
        		return ResultObj.BACKINPORT_ERROR;
        	}
        		
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.BACKINPORT_ERROR;
        }
    }

}
