package account;

import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		Valuable[] objectList = new Valuable[4];
		
		CheckingAccount a = new CheckingAccount(100, 50, 0.01, 0.07);
		SavingsAccount b = new SavingsAccount(100, 0.05);
		Human c = new Human("Mark", 20);
		Car d = new Car("MyCar", 5000);
		
		objectList[0] = a;
		objectList[1] = b;
		objectList[2] = c;
		objectList[3] = d;
		
		for(Valuable objectItem : objectList) {
			System.out.printf("%s ",  objectItem.toString());
			System.out.printf("6 month later Valuable : %.2f\n\n", objectItem.EstimateValue(6));
		}
		
	}
}
