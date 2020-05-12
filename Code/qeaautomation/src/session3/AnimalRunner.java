package session3;

import java.util.ArrayList;
import java.util.List;

public class AnimalRunner {
	public static void main(String [] args) {
		
		List<Animal> animals = new ArrayList<>();
		
		animals.add(new Cat(5));
		animals.add(new Dog(15));
		animals.add(new Cat(10));
		
		allSpeak(animals);
		
	}
	
	public static void allSpeak(List<Animal> animals) {
		for(Animal a : animals) {
			System.out.println(a.getWeight() + "-kilo " + a.getClass().getSimpleName() + " says " + a.speak());
		}
	}
}
