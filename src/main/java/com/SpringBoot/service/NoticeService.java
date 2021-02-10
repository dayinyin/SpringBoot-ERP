package com.SpringBoot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.bean.Notice;
import com.SpringBoot.dao.NoticeImp;

@Service
public class NoticeService implements NoticeImp {

	@Autowired
	NoticeImp noticeImp;
	
	@Override
	public List<Notice> select(String title, String opername,Integer index,Integer limit) {
		List<Notice> notice = noticeImp.select(title, opername, index, limit);
		return notice;
	}

	@Override
	public void delect(Integer id) {
		noticeImp.delect(id);
	}

	@Override
	public Notice selectById(Integer id) {
		Notice notice = noticeImp.selectById(id);
		return notice;
	}

	@Override
	public void update(Integer id, String content) {
		// TODO 自动生成的方法存根
		noticeImp.update(id, content);
	}

	@Override
	public void insert(String title, String content, Date createtime, String opername) {
		// TODO 自动生成的方法存根
		noticeImp.insert(title, content, createtime, opername);
	}

	

}
