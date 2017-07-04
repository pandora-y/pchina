package com.pchina.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pchina.cms.common.pagination.model.PaginationList;
import com.pchina.cms.common.pagination.model.SimplePaginatedList;
import com.pchina.cms.common.utils.DateUtils;
import com.pchina.cms.core.dao.ArticleMapper;
import com.pchina.cms.core.model.Article;
import com.pchina.cms.core.query.ArticleVo;
import com.pchina.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;

	public List<Article> findAll(ArticleVo articleVo) throws Exception {
		List<Article> list = articleMapper.findAll(articleVo);
		return list;
	}

	public PaginationList<Article> findPage(ArticleVo articleVo) throws Exception {
		int totalCount = articleMapper.findCount(articleVo);
		List<Article> list = articleMapper.findPage(articleVo);
		PaginationList<Article> plist = new SimplePaginatedList<Article>(list, articleVo.getCurrentPage(), articleVo.getPageSize(), totalCount);
		return plist;
	}

	public Article findByPrimaryKey(int id) throws Exception {
		Article article = articleMapper.findByPrimaryKey(id);
		return article;
	}

	public void add(Article article) throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date();
		article.setCreateTime(date);
		articleMapper.add(article);
	}

	public void update(Article article) throws Exception {
		// TODO Auto-generated method stub
		articleMapper.update(article);
		
	}

	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		articleMapper.delete(id);
	}

}
