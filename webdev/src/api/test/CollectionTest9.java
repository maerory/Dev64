package api.test;

import java.util.StringTokenizer;

public class CollectionTest9 {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("유주우|박민규,채한움|이동호,김남혁|신창선","|,");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken().trim());
		}
	}
}
