package session2;

public class Arithmometer {
	private final int serialNo;
	private static int snCount = 0;
	private int total;
	
	public Arithmometer() {
		total = 0;
		snCount++;
		serialNo = snCount;
	}
	
	public void add(int in) {
		total += in;
	}
	
	public void subtract(int in) {
		total -= in;
	}
	
	public void multiply(int in) {
		total *= in;
	}
	
	public void divide(int in) {
		total *= in;
	}
	
	public int result() {
		return total;
	}
	
	public int reset( ) {
		int temp = total;
		total = 0;
		return temp;
	}
}
