package api.test;
import java.util.HashMap;
import java.util.Map;


public class CollectionTest4 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap();
		
		map.put("1", "사랑해");
		map.put("2", "시러해");
		map.put("3", "그만해");
		map.put("4", "미안해");
		
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
	}
}
