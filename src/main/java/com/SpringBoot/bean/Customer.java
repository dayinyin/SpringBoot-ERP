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
public class Customer {
	
    private Integer id;

    private String customername;

    private String zip;

    private String address;

    private String telephone;

    private String connectionpersion;

    private String phone;

    private String bank;

    private String account;

    private String email;

    private String fax;

    private Integer available;

}
