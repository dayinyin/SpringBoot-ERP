package com.SpringBoot.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
	
	

	//Subject,SecurityManager,Realms
	
	//ShiroFilterFactoryBean	创建subject
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		//设置管理器
		bean.setSecurityManager(defaultWebSecurityManager);
		
		Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
		/*
		 * 进入页面要通关认证
		 * */
		filterChainDefinitionMap.put("/bus/**", "authc");
		filterChainDefinitionMap.put("/sys/index", "authc");
		
		filterChainDefinitionMap.put("/customer/**", "authc");
		filterChainDefinitionMap.put("/dept/**", "authc");
		filterChainDefinitionMap.put("/goods/**", "authc");
		filterChainDefinitionMap.put("/inport/**", "authc");
		filterChainDefinitionMap.put("/loginfo/**", "authc");
		filterChainDefinitionMap.put("/menu/**", "authc");
		filterChainDefinitionMap.put("/notice/**", "authc");
		filterChainDefinitionMap.put("/outport/**", "authc");
		filterChainDefinitionMap.put("/permission/**", "authc");
		filterChainDefinitionMap.put("/provider/**", "authc");
		filterChainDefinitionMap.put("/role/**", "authc");
		filterChainDefinitionMap.put("/salesback/**", "authc");
		filterChainDefinitionMap.put("/sales/**", "authc");
		filterChainDefinitionMap.put("/user/**", "authc");
		
		filterChainDefinitionMap.put("/loginfo/deleteLoginfo", "roles[root]");
		filterChainDefinitionMap.put("/loginfo/batchDeleteLoginfo", "roles[root]");
		
		filterChainDefinitionMap.put("/customer/deleteCustomer", "roles[root]");
		
		filterChainDefinitionMap.put("/dept/deleteDept", "roles[root]");
		
		filterChainDefinitionMap.put("/goods/deleteGoods", "roles[root]");
		
		filterChainDefinitionMap.put("/inport/deleteInport", "roles[root]");
		filterChainDefinitionMap.put("/inport/run", "roles[root]");
		
		filterChainDefinitionMap.put("/menu/deleteMenu", "roles[root]");
		
		filterChainDefinitionMap.put("/notice/deleteNotice", "roles[root]");
		filterChainDefinitionMap.put("/notice/batchDeleteNotice", "roles[root]");
		
		filterChainDefinitionMap.put("/outport/deleteOutport", "roles[root]");
		filterChainDefinitionMap.put("/outport/addOutport", "roles[root]");
		
		filterChainDefinitionMap.put("/permission/deletePermission", "roles[root]");
		
		filterChainDefinitionMap.put("/provider/deleteProvider", "roles[root]");
		
		filterChainDefinitionMap.put("/role/deleteRole", "roles[root]");
		
		filterChainDefinitionMap.put("/salesback/deleteSalesback", "roles[root]");
		filterChainDefinitionMap.put("/salesback/addSalesback", "roles[root]");
		
		filterChainDefinitionMap.put("/sales/deleteSales", "roles[root]");
		
		filterChainDefinitionMap.put("/user/deleteUser/*", "roles[root]");
		filterChainDefinitionMap.put("/user/resetPwd/*", "roles[root]");
		filterChainDefinitionMap.put("/user/addUser", "roles[root]");
		filterChainDefinitionMap.put("/user/updateUser", "roles[root]");

		
		
		//拦截器
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		//设置登录请求
		bean.setLoginUrl("/index.html");
				
		//设置未授权
//		bean.setUnauthorizedUrl("");
		
		return bean;
	}
	
	
	//DafaultwebsecurityManager   管理器——subject
	@Bean
	public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(userRealm);
		return defaultWebSecurityManager;
	}
	
	//创建realm对象，自定义
	@Bean
	public UserRealm userRealm() {
		
		return new UserRealm();
	} 
}
