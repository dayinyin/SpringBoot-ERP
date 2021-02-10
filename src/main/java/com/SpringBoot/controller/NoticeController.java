package com.SpringBoot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.bean.Notice;
import com.SpringBoot.bean.User;
import com.SpringBoot.common.DataGridView;
import com.SpringBoot.common.LayuiJson;
import com.SpringBoot.common.ResultObj;
import com.SpringBoot.service.NoticeService;
import com.SpringBoot.vo.NoticeVo;
import com.fasterxml.jackson.annotation.JsonFormat;


@RestController
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    
    @Autowired
	LayuiJson layuiJson;
    
    
    /**
     * 公告的查询
     * @param noticeVo
     * @return
     */
    @RequestMapping("loadAllNotice")
    public LayuiJson<Notice> loadAllNotice(String title,String opername
    		,Integer page,Integer limit){
    	
    	int index=(page-1)*limit;
    	List<Notice> data = noticeService.select(title, opername, index, limit);
		layuiJson.setCode(0);
		layuiJson.setCount(1000);
		layuiJson.setData(data);

		return layuiJson;

    }

    /**
     * 添加公告
     * @param noticeVo
     * @return
     */
    @RequestMapping("addNotice")
    public ResultObj addNotice(String title,String content){
    	
    	try {
    		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
    		Session session = subject.getSession();
    		String  opername = session.getAttribute("username").toString();
    		noticeService.insert(title, content,new Date(), opername);
    		return ResultObj.ADD_SUCCESS;
    	}catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
        	
          
    }

    /**
     * 修改公告
     * @param noticeVo
     * @return
     */
//    @RequestMapping("updateNotice")
//    public void updateNotice(Integer id,String title,String content){
//
//        	noticeService.update(id, content);
//           
//    }

    /**
     * 删除公告
     * @param noticeVo
     * @return
     */
    @RequestMapping("deleteNotice")
    public ResultObj deleteNotice(Integer id){
        try {
            noticeService.delect(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除公告
     * @param noticeVo
     * @return
     */
    @RequestMapping("batchDeleteNotice")
    public ResultObj batchDeleteNotice(NoticeVo noticeVo){
        try {
        	List<Integer> idList = new ArrayList<Integer>();
            for (Integer id : noticeVo.getIds()) {
                idList.add(id);
            }
            for(Integer id :idList) {
            	noticeService.delect(id);
            }
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


}

