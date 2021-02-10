package com.SpringBoot.config;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoot.bean.User;
import com.SpringBoot.service.UserService;

//自定义realm
public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	HttpSession session;

	@Autowired
	UserService userService;
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		
		if(user.getType()==0) {
			info.addRole("root");
		}
		
		return info;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	
		UsernamePasswordToken userToken =(UsernamePasswordToken) token;
		User user = userService.select(userToken.getUsername());
		
		if(user==null) {
			return null;
		}else {
			session.setAttribute("username",user.getName());
			session.setAttribute("type",user.getType());
			session.setAttribute("user", user);
			return new SimpleAuthenticationInfo(user,user.getPwd(),this.getName());
		}
		
	}
	
	
}
