package net.n1books.dev.article.controllers;

import java.util.List;

public interface ArticleDAO {

	void insert(ArticleVO articleVO) throws Exception;

	List<ArticleVO> getArticleList() throws Exception;

	ArticleVO getArticle(long no) throws Exception;

	boolean delete(ArticleVO articleVO) throws Exception;

	boolean update(ArticleVO articleVO) throws Exception;

	boolean updateReadCount(long no) throws Exception;

}
