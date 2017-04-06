package account;

public class Human implements Valuable {
	private String name;
	private int age;
	
	Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public double EstimateValue(int month) {
		return Double.POSITIVE_INFINITY;
	}
	
	public String toString() {
		return String.format("Hunam name: %s\n registered age: %d\n", this.name, this.age);
	}
}
