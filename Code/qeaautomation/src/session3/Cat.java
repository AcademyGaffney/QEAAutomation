package session3;

public class Cat extends Animal{
	
	public Cat(double weight) {
		super(weight);
	}
	
	public Cat() {
		this(6);
	}

	@Override
	public String speak() {
		return "Meow";
	}
}
