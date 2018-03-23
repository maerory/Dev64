package api.test;

import java.util.LinkedList;
import java.util.List;

public class CollectionTest6 {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		list.add("내딸 서영이");printList(list);
		list.add("넝쿨째 굴러온 당신");printList(list);
		list.add("황금빛 내인생");printList(list);
		list.add("아버지가 이상해");printList(list);
		list.add(3,"리턴"); printList(list);
		list.set(1, "너의 목소리가 들려"); printList(list);
		
		
	}

	private static void printList(List<String> list) {
		for (String name:list) {
			System.out.print(name + "\t");
		}
		System.out.println();
	}
}
