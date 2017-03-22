package account;

public class Balance {
	private double balance;
	private String name;
	
	// 출금 메소드 
	public void withdraw(double debit) {
		if(balance >= debit) {
			System.out.printf("Substracting %f from %s balance\n", debit, name);
			balance -= debit;
		} else {
			System.out.printf("Substracting %f from %s balance\n", debit, name);
			System.out.printf("Debit amount exceeded account balance\n");
		}
	}
	// 입금 메소드 
	public void deposit(double credit) {
		balance += credit;
	}
	

	public double getBalance() {
		return balance;
	}
	
	// 생성
	public Balance(double cash, String acName) {
		balance = cash;
		name = acName;
	}

}
