package api.test;

import java.util.LinkedList;

public class CollectionTest8 {
	public static void main(String[] args) {
		LinkedList<String> stack = new LinkedList<String>();
		
		printstack(stack);
		stack.addLast("브람스"); 
		stack.addLast("베토벤");
		stack.addLast("베르디"); 
		stack.addLast("모차르트"); 
		stack.addLast("비발디"); 
		stack.addLast("말러"); 
		
		while (!stack.isEmpty()) {
			System.out.print(stack.poll() + ": " );
			printstack(stack);
		}
	}
	
	private static void printstack(LinkedList<String> stack) {
		for (String name:stack) {
			System.out.print(name + "\t");
		}
		System.out.println();
	}
}
