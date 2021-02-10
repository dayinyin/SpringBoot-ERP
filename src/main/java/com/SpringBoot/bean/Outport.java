package com.SpringBoot.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Outport {

	private Integer id;

    private Integer providerid;

    private String paytype;

    private Date outputtime;

    private String operateperson;

    private Double outportprice;

    private Integer number;

    private String remark;

    private Integer goodsid;

    /**
     * 供应商姓名
     */
    private String providername;

    /**
     * 商品名称
     */
    private String goodsname;

    /**
     * 商品规格
     */
    private String size;

}
