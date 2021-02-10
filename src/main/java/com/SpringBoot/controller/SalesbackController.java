package com.SpringBoot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Sales;
import com.SpringBoot.bean.Salesback;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.service.SalesService;
import com.SpringBoot.service.SalesbackService;

@RestController
@RequestMapping("salesback")
public class SalesbackController {
	
	@Autowired
	LayuiJson layuiJson;
	
	@Autowired
	SalesbackService salesbackService;
	
	@Autowired
	SalesService salesService;
	
	@Autowired
	HttpSession httpSession;
	
	@RequestMapping("loadAllSalesback")
	public LayuiJson<Salesback> loadAllSalesback(Integer customerid,Integer goodsid,Integer page,Integer limit){
		int index=(page-1)*limit;
		List<Salesback> data = salesbackService.select(customerid, goodsid, index, limit);
		layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);
		return layuiJson;
	}

	/**
     * 删除商品销售退回信息
     * @param id
     * @return
     */
    @RequestMapping("deleteSalesback")
    public ResultObj deleteSalesback(Integer id){
        try {
            salesbackService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @Transactional
    @RequestMapping("addSalesback")
    public ResultObj addSalesback(Integer id ,Integer number,String remark) {
    	
    	try {
    		Sales s = salesService.selectById(id);
    		Date salesbacktime=new Date();
    		String operateperson = (String) httpSession.getAttribute("username");
    		Integer customerid = s.getCustomerid();
    		String paytype = s.getPaytype();
    		Double salebackprice = s.getSaleprice();
    		Integer goodsid = s.getGoodsid();
    		
    		if(s.getNumber()==number) {
    			
    			salesbackService.insert(customerid, paytype, salesbacktime, salebackprice, operateperson, number, remark, goodsid);
    			salesService.delete(id);
    			
    	    	return ResultObj.BACKINPORT_SUCCESS;
    			
    		}else if(s.getNumber()>number) {
    			
    			salesbackService.insert(customerid, paytype, salesbacktime, salebackprice, operateperson, number, remark, goodsid);
    			salesService.updateNumber(id, s.getNumber()-number);
    	    	return ResultObj.BACKINPORT_SUCCESS;
    		}else {
    			
    			return ResultObj.BACKINPORT_ERROR;
    		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return ResultObj.BACKINPORT_ERROR;
    	
    }
	
}
