package com.pchina.cms.service;

import java.util.List;

import com.pchina.cms.common.pagination.model.PaginationList;
import com.pchina.cms.core.model.Article;
import com.pchina.cms.core.query.ArticleVo;

public interface ArticleService {
	public List<Article> findAll(ArticleVo articleVo) throws Exception;
	
	public PaginationList<Article> findPage(ArticleVo articleVo) throws Exception;
	
	public Article findByPrimaryKey(int id) throws Exception;
	
	public void add(Article article) throws Exception;
	
	public void update(Article article) throws Exception;
	
	public void delete(int id) throws Exception;
}
