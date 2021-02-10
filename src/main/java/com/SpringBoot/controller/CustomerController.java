package com.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Customer;
import com.SpringBoot.common.DataGridView;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	LayuiJson layuiJson;
	
	@RequestMapping("loadAllCustomer")
	public LayuiJson<Customer> loadAllCustomer(String customername,String connectionpersion,
			String phone,Integer page,Integer limit){
		int index=(page-1)*limit;
		List<Customer> data = customerService.select(customername, connectionpersion, phone, index, limit);
		layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);
		return layuiJson;
	}
	
	@RequestMapping("loadAllCustomerForSelect")
	public DataGridView loadAllCustomerForSelect(){
		
		List<Customer> list = customerService.selectName();
		return new DataGridView(list);
	}
	
	
	@RequestMapping("updateCustomer")
    public ResultObj updateCustomer(Integer id, String customername, String zip, String address, String telephone,
			String connectionpersion, String phone, String bank, String account, String email, String fax,
			Integer available){
        try {
        	
            customerService.update(id, customername, zip, address, telephone, 
            		connectionpersion, phone, bank, account, email, fax, available);
            
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
	
	@RequestMapping("addCustomer")
    public ResultObj addCustomer(String customername, String zip, String address, String telephone, String connectionpersion,
			String phone, String bank, String account, String email, String fax, Integer available){
        try {
            customerService.insert(customername, zip, address, telephone, connectionpersion, 
            		phone, bank, account, email, fax, available);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
	
	@RequestMapping("deleteCustomer")
    public ResultObj deleteCustomer(Integer id){
        try {
            customerService.delete(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}
