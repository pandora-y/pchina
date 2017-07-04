package com.pchina.cms.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pchina.cms.common.pagination.model.PaginationList;
import com.pchina.cms.core.model.Article;
import com.pchina.cms.core.query.ArticleVo;
import com.pchina.cms.service.ArticleService;

@Controller
@RequestMapping("/admin/article/")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="list")
	public ModelAndView articleList(HttpServletRequest request, ArticleVo articleVo, ModelAndView modelAndView) {
		try {
			PaginationList<Article> pageDataList = articleService.findPage(articleVo);
			modelAndView.addObject("pageDataList", pageDataList);
			modelAndView.setViewName("admin/article/index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value="addJson")
	public String addJson(HttpServletRequest request, Article article) {
		try {
			articleService.add(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list";
	}
	
	@RequestMapping(value="add")
	public String addView(HttpServletRequest request, Article article) {
		return "admin/article/add";
	}
	
	@RequestMapping(value="update")
	public ModelAndView editView(HttpServletRequest request, Integer id, ModelAndView modelAndView) {
		
		try {
			Article article = articleService.findByPrimaryKey(id);
			modelAndView.addObject("article", article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modelAndView.setViewName("admin/article/edit");
		return modelAndView;
	}
	
	@RequestMapping(value="updateJson")
	public String updateJson(HttpServletRequest request, Article article) {
		try {
			articleService.update(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list";
	}
	
	@RequestMapping(value="deleteJson")
	public String deleteJson(Integer id) {
		try {
			articleService.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list";
	}
}
