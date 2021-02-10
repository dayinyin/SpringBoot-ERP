package com.SpringBoot.controller;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("sys")
public class SystemController {
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("toAddOrUpdate")
    public String toAddOrUpdate(){

        return "system/notice/addOrUpdate";
    }
	
		
    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){

        return "system/index/login";
    }

    /**
     * 跳转到个人资料页面
     * @return
     */
    @RequestMapping("toUserInfo")
    public String toUserInfo(){
        return "system/user/userInfo";
    }

    /**
     * 跳转到修改密码页面
     * @return
     */
    @RequestMapping("toChangePassword")
    public String toChangePassword(){
        return "system/user/changePassword";
    }
    
    /**
     * 退出然后跳转到登陆页面
     * @return
     */
    @RequestMapping("toSignOut")
    public String toSignOut(){
        //销毁session
    	Subject subject = SecurityUtils.getSubject();
    	subject.logout();
    	session.invalidate();
    	session.removeAttribute("user");
        return "system/index/login";
    }

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "system/index/index";
    }

    /**
     * 跳转到登陆台
     * @return
     */
    @RequestMapping("toDeskManager")
    public String toDeskManager(){
        return "system/index/deskManager";
    }

    /**
     * 跳转到日志管理
     * @return
     */
    @RequestMapping("toLoginfoManager")
    public String toLoginfoManager(){
        return "system/loginfo/loginfoManager";
    }

    /**
     * 跳转到公告管理
     * @return
     */
    @RequestMapping("toNoticeManager")
    public String toNoticeManager(){
        return "system/notice/noticeManager";
    }

    /**
     * 跳转到部门管理
     * @return
     */
    @RequestMapping("toDeptManager")
    public String toDeptManager(){
        return "system/dept/deptManager";
    }

    /**
     * 跳转到部门管理--left
     * @return
     */
    @RequestMapping("toDeptLeft")
    public String toDeptLeft(){
        return "system/dept/deptLeft";
    }

    /**
     * 跳转到部门管理--right
     * @return
     */
    @RequestMapping("toDeptRight")
    public String toDeptRight(){
        return "system/dept/deptRight";
    }

    /**
     * 跳转到菜单管理
     * @return
     */
    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }

    /**
     * 跳转到菜单管理--left
     * @return
     */
    @RequestMapping("toMenuLeft")
    public String toMenuLeft(){
        return "system/menu/menuLeft";
    }

    /**
     * 跳转到菜单管理--right
     * @return
     */
    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return "system/menu/menuRight";
    }

    /**
     * 跳转到权限管理
     * @return
     */
    @RequestMapping("toPermissionManager")
    public String toPermissionManager(){
        return "system/permission/permissionManager";
    }

    /**
     * 跳转到权限管理--left
     * @return
     */
    @RequestMapping("toPermissionLeft")
    public String toPermissionLeft(){
        return "system/permission/permissionLeft";
    }

    /**
     * 跳转到权限管理--right
     * @return
     */
    @RequestMapping("toPermissionRight")
    public String toPermissionRight(){
        return "system/permission/permissionRight";
    }

    /**
     * 跳转到角色管理
     * @return
     */
    @RequestMapping("toRoleManager")
    public String toRoleManager(){
        return "system/role/roleManager";
    }

    /**
     * 跳转到用户管理
     * @return
     */
    @RequestMapping("toUserManager")
    public String toUserManager(){
        return "system/user/userManager";
    }

    
    @RequestMapping("toIconManager")
    public String toIconManager(){
        return "redirect:/resources/page/systemSetting/icons.html";
    }

}
