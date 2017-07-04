package com.pchina.cms.core.dao;

import java.util.List;

import com.pchina.cms.core.model.Article;
import com.pchina.cms.core.query.ArticleVo;

public interface ArticleMapper {
	public List<Article> findAll(ArticleVo articleVo) throws Exception;
	public List<Article> findPage(ArticleVo articleVo) throws Exception;
	public Article findByPrimaryKey(int id) throws Exception;
	
	public int findCount(ArticleVo articleVo) throws Exception;
	
	public void add(Article article) throws Exception;
	
	public void update(Article article) throws Exception;
	
	public void delete(int id) throws Exception;
}
