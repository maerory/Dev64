package net.n1books.dev.article.controllers;

import java.util.List;

public interface ArticleDAO {

	List<ArticleVO> getArticleList() throws Exception;

	void insert(ArticleVO articleVO) throws Exception;

	ArticleVO getArticle(long no) throws Exception;

	boolean delete(ArticleVO articleVO) throws Exception;

	boolean update(ArticleVO articleVO) throws Exception;

	boolean updateReadcount(long no) throws Exception;

	List<ArticleVO> getArticlePageList(PageVO p) throws Exception;

	long getTotalArticle() throws Exception;

}
