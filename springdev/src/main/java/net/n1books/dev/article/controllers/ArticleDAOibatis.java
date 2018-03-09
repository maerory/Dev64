package net.n1books.dev.article.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("ibatis")
public class ArticleDAOibatis implements ArticleDAO{
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@Override
	public void insert(ArticleVO articleVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVO> getArticleList() throws Exception {
		return sqlMap.queryForList("article.getArticleList");
	}

	@Override
	public ArticleVO getArticle(long no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ArticleVO articleVO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ArticleVO articleVO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReadCount(long no) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
