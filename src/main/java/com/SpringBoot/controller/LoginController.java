package com.SpringBoot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.SpringBoot.bean.Loginfo;
import com.SpringBoot.common.ActiverUser;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.common.WebUtils;
import com.SpringBoot.service.LoginfoService;
import com.SpringBoot.vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Date;


@RestController
@RequestMapping("login")
public class LoginController {
	
    @Autowired
    private LoginfoService loginfoService;
    
    @RequestMapping("login")
    public ResultObj login(UserVo userVo,String code,HttpSession session,HttpServletRequest request){
    	
    	String rightCode = (String) request.getSession().getAttribute("rightCode");
        //前端传入的tryCode参数
        String tryCode = request.getParameter("tryCode");
    	
    		String remoteAddr = request.getRemoteAddr();
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(userVo.getLoginname(),userVo.getPwd());
            
            if (!rightCode.equals(tryCode)) {
            	
            	return ResultObj.LOGIN_ERROR_CODE;
            }else {
            	 try {
                     //对用户进行认证登陆
                     subject.login(token);
      	        Date logintime = new Date();
     			loginfoService.insert(userVo.getLoginname(), remoteAddr, logintime);
                     return ResultObj.LOGIN_SUCCESS;
                 } catch (AuthenticationException e) {
                     e.printStackTrace();
                     return ResultObj.LOGIN_ERROR_PASS;
                 }
            }
        
    }
    

}
