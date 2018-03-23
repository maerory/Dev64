package api.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionTest3 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("키무라 타쿠야");
		set.add("시이나 링고");
		set.add("사카이 마사토");
		set.add("나카무라상");
		
		Iterator iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
