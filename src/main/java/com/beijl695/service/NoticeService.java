package com.beijl695.service;

import java.util.List;

import com.beijl695.entity.Notice;
import com.beijl695.entity.PageBean;

public interface NoticeService {

	public List<Notice> findNoticeList(Notice s_notice, PageBean pageBean);
	
	public Notice getNoticeById(int noticeId);
	
	public Long getNoticeCount(Notice s_notice);
	
	public void saveNotice(Notice notice);
	
	public void delete(Notice notice);
}
