package com.beijl695.service;

import java.util.List;

import com.beijl695.entity.News;
import com.beijl695.entity.PageBean;

public interface NewsService {

	public List<News> findNewsList(News s_news, PageBean pageBean);
	
	public News getNewsById(int newsId);
	
	public Long getNewsCount(News s_news);
	
	public void saveNews(News news);
	
	public void delete(News news);
}
