package mx.com.dalvik;

public class DemoStringBuilder {
	public static void main(String[] args) {
		
		
		StringBuilder str = new StringBuilder();
		str.append("Demo ");
		str.append("String");
		str.append("Builder");
		
		System.out.println( str.toString() );
		
		new DemoStringBuilder()
			.test();
	}
	
	public void test() {
		System.out.println("...");
	}
	
}
