package api.test;

import java.util.HashMap;
import java.util.Map;

public class CollectionTest5 {
	public static void main(String[] args) {
		
		Map<Integer,BookVO> map = new HashMap<>();
		map.put(1,  new BookVO("죄와 벌1","도스 도스토예프스키", "민음사","고전서양",13000));
		map.put(2,  new BookVO("죄와 벌2","도스 도스토예프스키", "민음사","고전서양",13000));
		map.put(3,  new BookVO("죄와 벌3","도스 도스토예프스키", "민음사","고전서양",13000));
		map.put(4,  new BookVO("죄와 벌4","도스 도스토예프스키", "민음사","고전서양",13000));
		
		for(int i : map.keySet()) {
			System.out.println(map.get(i).getSubject());
		}
	}
}
