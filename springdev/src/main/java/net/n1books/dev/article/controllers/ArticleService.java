package net.n1books.dev.article.controllers;

import java.util.List;

public interface ArticleService {

	void insert(ArticleVO articleVO) throws Exception;

	List<ArticleVO> getArticleList() throws Exception;

	ArticleVO getArticle(long no) throws Exception;

	void delete(ArticleVO articleVO) throws Exception;
	
	void update(ArticleVO articleVO) throws Exception;

	void updateReadcount(long no) throws Exception;

}
