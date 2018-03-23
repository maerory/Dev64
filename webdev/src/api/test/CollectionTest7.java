package api.test;

import java.util.LinkedList;

public class CollectionTest7 {
	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<String>();
		
		printqueue(queue);
		queue.offer("브람스"); printqueue(queue);
		queue.offer("베토벤");	printqueue(queue);	
		queue.offer("베르디"); printqueue(queue);
		queue.offer("모차르트"); printqueue(queue);
		queue.offer("비발디"); printqueue(queue);
		queue.offer("말러"); printqueue(queue);
		
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + ": " );
			printqueue(queue);
		}
	}
	
	private static void printqueue(LinkedList<String> queue) {
		for (String name:queue) {
			System.out.print(name + "\t");
		}
		System.out.println();
	}
}
