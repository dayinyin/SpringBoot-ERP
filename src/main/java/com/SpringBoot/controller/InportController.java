package com.SpringBoot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Goods;
import com.SpringBoot.bean.Inport;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.service.GoodsService;
import com.SpringBoot.service.InportService;

@RestController
@RequestMapping("inport")
public class InportController {
	
	@Autowired
	LayuiJson layuiJson;
	
	@Autowired
	InportService inportService;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping("loadAllInport")
	public LayuiJson<Inport> loadAllInport(Integer providerid,Integer goodsid,Integer page,Integer limit){
		int index=(page-1)*limit;
		List<Inport> data = inportService.select(providerid, goodsid, index, limit);
		layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);
		return layuiJson;
		
	}
	
	  /**
     * 添加进货商品
     * @param inportVo
     * @return
     */
    @RequestMapping("addInport")
    public ResultObj addInport(Integer providerid,Integer goodsid,Integer number,Double inportprice,String remark,String paytype){
        try {
        	Date inporttime = new Date();
        	String operateperson = (String) httpSession.getAttribute("username");
        	inportService.insert(paytype, inporttime, operateperson, number, remark, inportprice, providerid, goodsid);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    
    /**
     * 更新进货商品
     * @param inportVo
     * @return
     */
    @RequestMapping("updateInport")
    public ResultObj updateInport(Integer id,Integer providerid,Integer goodsid,Integer number,Double inportprice,String remark,String paytype){
        try {
        	Date inporttime = new Date();
        	String operateperson = (String) httpSession.getAttribute("username");
            inportService.update(id, paytype, inporttime, number, remark, inportprice, providerid, goodsid, operateperson);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }

    }
    
    /**
     * 删除进货商品
     * @param id
     * @return
     */
    @RequestMapping("deleteInport")
    public ResultObj deleteInport(Integer id){
        try {
            inportService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping("run")
    public ResultObj runInport(Integer id,Integer number) {
    	
    	try {
    		
    		Inport i = inportService.selectById(id);
    		Date inporttime = new Date();
    		String remark = i.getRemark();
    		String paytype = i.getPaytype();
        	Integer goodsid = i.getGoodsid();
        	Double inportprice = i.getInportprice();
        	Integer providerid = i.getProviderid();
        	String operateperson = (String) httpSession.getAttribute("username");
        	
        	Goods g = goodsService.selectById(goodsid);
        	Integer goodsNumber = g.getNumber();
        	
    		if(i.getNumber()==number) {
    			
    			goodsService.updateNumber(goodsid, number+goodsNumber);
    			inportService.delete(id);
        		return ResultObj.RUN_SUCCESS;
        		
        	}else if(i.getNumber()>number){
        		goodsService.updateNumber(goodsid, number+goodsNumber);
        		inportService.update(id, paytype, inporttime, i.getNumber()-number,remark, 
        				inportprice, providerid, goodsid, operateperson);
        		
        		return ResultObj.RUN_SUCCESS;
        	}else {
        		
        		
        		return ResultObj.RUN_ERROR;
        	}
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResultObj.RUN_ERROR;
		}
    	
    } 
    
    
    

}
