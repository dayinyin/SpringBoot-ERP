package com.SpringBoot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Sales;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.service.SalesService;

@RestController
@RequestMapping("sales")
public class SalesController {
	
	@Autowired
	LayuiJson layuiJson;
	
	@Autowired
	SalesService salesService;
	
	@Autowired
	HttpSession httpSession;
	
	@RequestMapping("loadAllSales")
	public LayuiJson<Sales> loadAllSales(Integer customerid,Integer goodsid,Integer page,Integer limit){
		int index=(page-1)*limit;
		List<Sales> data = salesService.select(customerid, goodsid, index, limit);
		layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);
		return layuiJson;
	}
	
	/**
     * 添加商品销售信息
     * @param salesVo
     * @return
     */
    @RequestMapping("addSales")
    public ResultObj addSales(Integer customerid, String paytype, Integer number,
			String remark, Double saleprice, Integer goodsid){
        try {
        	String operateperson = (String) httpSession.getAttribute("username");
        	Date salestime=new Date();
			salesService.insert(customerid, paytype, salestime, operateperson, number, remark, saleprice, goodsid);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    /**
     * 更新商品销售信息
     * @param salesVo
     * @return
     */
    @RequestMapping("updateSales")
    public ResultObj updateSales(Integer id,Integer customerid, String paytype, Integer number,
			String remark, Double saleprice, Integer goodsid){
        try {
        	String operateperson = (String) httpSession.getAttribute("username");
        	Date salestime=new Date();
            salesService.update(id, customerid, paytype, salestime, operateperson, number, remark, saleprice, goodsid);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }

    }
	
    /**
     * 删除商品销售信息
     * @param id
     * @return
     */
    @RequestMapping("deleteSales")
    public ResultObj deleteSales(Integer id){
        try {
            salesService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}
