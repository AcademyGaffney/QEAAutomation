package session3;

public abstract class Animal {
	
	private double weight;
	
	public Animal(double weight) {
		this.weight = weight;
	}
	
	double getWeight() {
		return weight;
	}

	public abstract String speak();
}
