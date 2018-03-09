package net.n1books.dev.article.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	@Qualifier("ibatis")
	private ArticleDAO dao;

	@Override
	public void insert(ArticleVO articleVO) throws Exception {
		dao.insert(articleVO);
	}

	@Override
	public List<ArticleVO> getArticleList() throws Exception {
		return dao.getArticleList();
	}

	@Override
	public ArticleVO getArticle(long no) throws Exception {
		ArticleVO articleVO = dao.getArticle(no);
		if (articleVO == null) {
			throw new NoArticleException(no + "번 게시물이 존재하지 않습니다.");
		}
		return articleVO;
	}

	@Override
	public void delete(ArticleVO articleVO) throws Exception {
		if (!dao.delete(articleVO)) {
			throw new RuntimeException("노게시물");
		}
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		if (!dao.update(articleVO)) {
			throw new RuntimeException("비밀번호 오류");
		}
	}

	@Override
	public void updateReadcount(long no) throws Exception {
		if (!dao.updateReadCount(no)) {
			throw new RuntimeException("조회수 증가 실패");
		}
		
	}

}
