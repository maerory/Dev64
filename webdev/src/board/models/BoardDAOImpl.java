package board.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAOImpl implements BoardDAO{
	private static BoardDAO boardDAO = null;
//	private String className;
//	private String url;
//	private String username;
//	private String password;
	
	Context context = null;
	DataSource ds = null;
	
	public static BoardDAO getInstance() {
		if (boardDAO == null) {
			boardDAO = new BoardDAOImpl();
		}
		return boardDAO;
	}
	
	public BoardDAOImpl() {
//		String fileName = this.getClass().getResource("").getPath() + "database.properties";
		try {
//			Properties pr = new Properties();
//			pr.load(new FileInputStream(fileName));
//			
//			className = pr.getProperty("className");
//			url = pr.getProperty("url");
//			username = pr.getProperty("username");
//			password = pr.getProperty("passward");
//			
//			Class.forName(className);
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/mydbcp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dbClose(ResultSet rs, PreparedStatement ps, Connection conn) {
		if (rs != null) try{rs.close();} catch(Exception e){}
		if (ps != null) try{ps.close();} catch(Exception e){}
		if (conn != null) try{conn.close();} catch(Exception e){}
	}

	private void dbClose(PreparedStatement ps, Connection conn) {
		if (ps != null) try{ps.close();} catch(Exception e){}
		if (conn != null) try{conn.close();} catch(Exception e){}
	}
	
	private Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(url, username, password);
		return ds.getConnection();
	}
	
	@Override
	public List<BoardVO> getBoardList() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select no, name, title, to_char(regdate,'YYYY/MM/DD') as regdate, readcount");
		sql.append(" from BOARD");
		sql.append(" order by no desc");
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","n1","n1");
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO boardVO = new BoardVO();
				boardVO.setNo(rs.getLong("no"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setName(rs.getString("name"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setRegdate(rs.getString("regdate"));
				list.add(boardVO);
			}
		} finally {
			dbClose(rs,ps,conn);
		}
		return list;
	}

	@Override
	public boolean insertBoard(BoardVO boardVO) throws SQLException, ClassNotFoundException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO board(no, name, title, content, passwd) " );
		sql.append("VALUES(seq_board.nextval,?,?,?,?)");
		
		Connection conn = null;
		PreparedStatement ps = null;

		boolean result = false;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","n1","n1");
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, boardVO.getName());
			ps.setString(2, boardVO.getTitle());
			ps.setString(3, boardVO.getContent());
			ps.setString(4, boardVO.getPasswd());
			ps.executeUpdate();
			result = true;
		} finally {
			if (ps != null) try {ps.close();} catch(Exception e) {}
			if (conn!= null) try {conn.close();} catch(Exception e){}
		}
		
		return result;
	}
	
	@Override
	public boolean deleteBoard(BoardVO boardVO) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from board");
		sql.append(" where  no=? and passwd=?");

		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql.toString());
			ps.setLong(1, boardVO.getNo());
			ps.setString(2, boardVO.getPasswd());
			if (ps.executeUpdate() > 0)	{
				result = true;
			} else {
				throw new RuntimeException("Password Error");
			}
		} finally {
			dbClose(ps,conn);
		}
		return result;
	}

	@Override
	public BoardVO getArticle(BoardVO boardVO) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select no, name, title, content, regdate, readcount ");
		sql.append(" from   board");
		sql.append(" where  no=?");
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql.toString());
			ps.setLong(1, boardVO.getNo());
			rs = ps.executeQuery();
			if (rs.next()) { 
				boardVO.setTitle(rs.getString("title"));
				boardVO.setName(rs.getString("name"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setRegdate(rs.getString("regdate"));
				boardVO.setContent(rs.getString("content"));
			} else {
				throw new RuntimeException(
						boardVO.getNo() + "번 게시물이 존재하지 않습니다.");
			}
		} finally {
			dbClose(rs,ps,conn);
		}

		return boardVO;
	}
	
	@Override
	public boolean updateBoard(BoardVO boardVO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append(" update board set");
		sql.append("        name=?, title=?, content=?");
		sql.append(" where  no=? and passwd=?");

		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, boardVO.getName());
			ps.setString(2, boardVO.getTitle());
			ps.setString(3, boardVO.getContent());
			ps.setLong(4, boardVO.getNo());
			ps.setString(5, boardVO.getPasswd());
			if (ps.executeUpdate() > 0)	{ 
				result = true;
			} else {
				throw new RuntimeException("Password Error");
			}
		} finally {
			dbClose(ps,conn);
		}

		return result;
	}

	@Override
	public void updateReadcount(BoardVO boardVO) {
		Connection conn = null;
		PreparedStatement ps = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" update board set");
		sql.append("        readcount = readcount + 1");
		sql.append(" where  no=?");
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql.toString());
			ps.setLong(1, boardVO.getNo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(ps, conn);
		}
	}
}
