package api.test;
import java.util.LinkedList;
import java.util.List;

import board.models.BoardVO;

public class CollectionTest {
	public static void main(String[] args) {
		List<BoardVO> list = new LinkedList<>();
		
		list.add(new BoardVO((long) 1,"신해철","그대에게","1122","숨가쁘게~","2018/02/01",100));
		list.add(new BoardVO((long) 2,"서태지","그대에게","1131","가즈아~~~","2018/02/02",200));
		list.add(new BoardVO((long) 3,"이승환","그대에게","1123","너에게로~~~","2018/02/03",300));
		
		for (BoardVO boardVO : list) {
			System.out.println(boardVO);
		}
	}
}
