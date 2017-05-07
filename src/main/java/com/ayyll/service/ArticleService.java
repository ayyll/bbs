package com.ayyll.service;

import java.sql.Timestamp;
import java.util.List;

import com.ayyll.entity.Article;
import com.ayyll.entity.PageBean;

public interface ArticleService {
	
	/**
	 * 获取帖子所有数据
	 * @return
	 */
	public List<Article> getArticleList();

	/**
	 * 根据id获取帖子数据
	 * @param aid 帖子id
	 * @return
	 */
	public Article getArticleByID(Integer aid);

	/**
	 * 发表新帖
	 * @param title
	 * @param content
	 * @param timestamp
	 * @param uid
	 * @param lable 
	 * @return
	 */
	public int addArticle(String title, String content,Timestamp timestamp,Integer uid, String lable);

	/**
	 * 根据uid获得用户的帖子数据
	 * @param uid
	 * @return
	 */
	public List<Article> getArticleByUID(Integer uid);

	/**
	 * 根据id删除帖子数据
	 * @param aid
	 * @return
	 */
	public int deleteArticleByID(Integer aid);

	/**
	 * 分页查询帖子数据
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean getArticlePageList(int currentPage, int pageSize);

	/**
	 * 关键字搜索
	 * @param key
	 * @return
	 */
	public List<Article> searchArticleByKey(String key);

	/**
	 * 置顶帖列表
	 * @return
	 */
	public List<Article> searchArticleByTop();

	/**
	 * 精品帖列表
	 * @return
	 */
	public List<Article> searchArticleByPerfect();

	/**
	 * 按标签搜索
	 * @return
	 */
	public List<Article> searchArticleByLable(String lab);

}
