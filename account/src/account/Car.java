package account;

public class Car implements Valuable {
	private double price;
	private String name;
	
	Car(String name, double price) {
		this.price = price;
		this.name = name;
	}
	public double estimateValue(int month) {
		price = price*0.8;	// 구입과 동시에 가감
		for(int i=0; i<month; i++) {
			price = price*0.99;	// 달마다 1퍼센트 가
		}
		return price;
	}
	public double estimateValue() {
		return estimateValue(1);
	}
	
	public String toString() {
		return String.format("Car name: %s\n initial price: %.2f\n", this.name, this.price);
	}

}
