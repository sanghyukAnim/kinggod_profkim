package account;

public class Account {
	private double balance;
	private String name;
	
	// 출금 메소드 
	public void debit(double debit) {
		if(balance >= debit) {
			System.out.printf("Substracting %f from %s balance\n", debit, name);
			balance -= debit;
		} else {
			System.out.printf("Substracting %f from %s balance\n", debit, name);
			System.out.printf("Debit amount exceeded account balance\n");
		}
	}
	// 입금 메소드 
	public void credit(double cred) {
		balance += cred;
	}
	

	public double getBalance() {
		return balance;
	}
	
	protected void setBalance(double a) {
		balance = a;
	}
	
	// 생성
	public Account(double bal, String acName) {
		balance = bal;
		name = acName;
	}

}
