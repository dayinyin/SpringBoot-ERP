package com.SpringBoot.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Sales {

	 private Integer id;

	    private Integer customerid;

	    private String paytype;

	    private Date salestime;

	    private String operateperson;

	    private Integer number;

	    private String remark;

	    private Double saleprice;

	    private Integer goodsid;

	    /**
	     * 客户名称
	     */
	    private String customername;

	    /**
	     * 商品名称
	     */
	    private String goodsname;

	    /**
	     * 商品规格
	     */
	    private String size;
}
