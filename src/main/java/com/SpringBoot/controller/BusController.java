package com.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 *
 */
@Controller
@RequestMapping("bus")
public class BusController {

	/**
	 * customer
	 * @return
	 */
	@RequestMapping("toCustomerManager")
	public String toCustomerManager() {
		return "business/customer/customerManager";
	}
	
	/**
	 * provider
	 * @author admin
	 *
	 */
	
	@RequestMapping("toProviderManager")
	public String toProviderManager() {
		return "business/provider/providerManager";
	}
	
	/**
	 * Goods
	 * @author admin
	 *
	 */
	
	@RequestMapping("toGoodsManager")
	public String toGoodsManager() {
		return "business/goods/goodsManager";
	}
	
	/**
	 * Inport
	 * @author admin
	 *
	 */
	@RequestMapping("toInportManager")
	public String toInportManager() {
		return "business/inport/inportManager";
	}
	
	/**
	 * Outport
	 * @author admin
	 *
	 */
	@RequestMapping("toOutportManager")
	public String toOutportManager() {
		return "business/outport/outportManager";
	}
	
	/**
	 * Sales
	 * @author admin
	 *
	 */
	@RequestMapping("toSalesManager")
	public String toSalesManager() {
		return "business/sales/salesManager";
	}
	
	/**
	 * Salesback
	 * @author admin
	 *
	 */
	@RequestMapping("toSalesbackManager")
	public String toSalesbackManager() {
		return "business/salesback/salesbackManager";
	}
}
