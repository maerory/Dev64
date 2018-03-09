package net.n1books.dev.article.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("springjdbc")
public class ArticleDAOImpl implements ArticleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(ArticleVO articleVO) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO t_article(no, title, name, passwd, content)");
		sql.append(" VALUES(seq_article.nextval, ?, ?, ?, ?)");
		
		Object[] args = {
			articleVO.getTitle(),
			articleVO.getName(),
			articleVO.getPasswd(),
			articleVO.getContent()
		};
		jdbcTemplate.update(sql.toString(), args);
	}

	@Override
	public List<ArticleVO> getArticleList() throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" select no, title, name, readcount ");
		sql.append(" 	, to_char(regdate,'YYYY/MM/DD') as regdate");
		sql.append(" from t_article");
		sql.append(" order by no desc");
		
		RowMapper<ArticleVO> rowMapper = new RowMapper<ArticleVO>() {

			@Override
			public ArticleVO mapRow(ResultSet rs, int rownum) throws SQLException {
				ArticleVO vo = new ArticleVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcount(rs.getInt("readcount"));
				return vo;
			}
			
		};
		return jdbcTemplate.query(sql.toString(), rowMapper);
	}

	@Override
	public ArticleVO getArticle(long no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" select no, title, name, readcount, regdate, content");
		sql.append(" from t_article");
		sql.append(" where no=?");

		
		RowMapper<ArticleVO> rowMapper = new RowMapper<ArticleVO>() {
			@Override
			public ArticleVO mapRow(ResultSet rs, int rownum) throws SQLException {
				ArticleVO vo = new ArticleVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setContent(rs.getString("content"));
				return vo;
			}
		};
		return jdbcTemplate.queryForObject(sql.toString(), new Object[] {no}, rowMapper);
	}

	@Override
	public boolean delete(ArticleVO articleVO) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from t_article");
		sql.append(" where no=? AND passwd=?");

		Object[] args = {
			articleVO.getNo(),
			articleVO.getPasswd()
		};
		
		return jdbcTemplate.update(sql.toString(),args) > 0;
	}
	
	@Override
	public boolean update(ArticleVO articleVO) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE t_article");
		sql.append(" SET name=?,title=?,content=?");
		sql.append(" where no=? and passwd=?");
		
		Object[] args = {
				articleVO.getName(),
				articleVO.getTitle(),
				articleVO.getContent(),
				articleVO.getNo(),
				articleVO.getPasswd()
		};
		
		return jdbcTemplate.update(sql.toString(), args) > 0;
		
	}

	@Override
	public boolean updateReadCount(long no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE t_article SET ");
		sql.append(" 	readcount = readcount + 1 ");
		sql.append(" WHERE no = ?");
		
		return jdbcTemplate.update(sql.toString(), new Object[] {no}) > 0;
	}

}
