package api.test;

public class StringTest01 {
	public static void main(String[] args) {
		String str1 = "반갑습네다.";
		String str2 = str1;
		
		System.out.println(str2 =str2.substring(4));
		System.out.println(str2);
		
		System.out.println("str1:" + str1);
		System.out.println("str2:" + str2);
	}
	
}
