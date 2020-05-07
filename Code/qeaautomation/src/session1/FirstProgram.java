package session1;

public class FirstProgram {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		System.out.println(compareDoubles(3.14+4, 7.14, 1.0000000001));

	}
	
	public static boolean compareDoubles(double first, double second, double margin) {
		double lowMargin = 1/margin;
		boolean result = first/second < margin && first/second > lowMargin;
		return result;
	}

}
