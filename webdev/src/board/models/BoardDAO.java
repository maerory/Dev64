package board.models;

import java.util.List;

public interface BoardDAO {
	public List<BoardVO> getBoardList() throws Exception;
	public boolean insertBoard(BoardVO boardVO) throws Exception;
	public void updateReadcount(BoardVO boardVO) throws Exception;
	public boolean updateBoard(BoardVO boardVO) throws Exception;
	public BoardVO getArticle(BoardVO boardVO) throws Exception;
	public boolean deleteBoard(BoardVO boardVO) throws Exception;
}
