package net.n1books.dev.article.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	@Qualifier("mybatisArticle")
	private ArticleDAO dao;
	
	private long pagesize=10;
	
	
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
			throw new RuntimeException("게시물이 존재하지 않거나 비밀번호가 틀립니다.");
		}
	}
	
	@Override
	public void update(ArticleVO articleVO) throws Exception {
		if (!dao.update(articleVO)) {
			throw new RuntimeException("비밀번호가 틀립니다.");
		}
	}

	@Override
	public void updateReadcount(long no) throws Exception {
		if (!dao.updateReadcount(no)) {
			throw new RuntimeException("조회수 증가 실패");
		}
	}

	@Override
	public List<ArticleVO> getArticlePageList(long pg) throws Exception {
		long startnum = (pg - 1) * pagesize + 1;
		long endnum   = pg * pagesize;
		PageVO p = new PageVO();
		p.setStartnum(startnum);
		p.setEndnum(endnum);
		
		return dao.getArticlePageList(p);
	}
	
	@Override
	public long getTotalArticle() throws Exception {
		return dao.getTotalArticle();
	}
	
	@Override
	public long getTotalPage(long totalArticle) throws Exception {
		return (long) Math.ceil((double)totalArticle / 10);
	}

	@Override
	public long getStartPage(long pg) throws Exception {
		return (pg - 1) / pagesize * pagesize + 1;
	}

	@Override
	public long getEndPage(long pg, long totalPage) throws Exception {
		long endPage = (pg - 1) / pagesize * pagesize + pagesize;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		return endPage;
	}
}
