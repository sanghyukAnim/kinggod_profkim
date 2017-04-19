package account;

public abstract class Account implements Valuable {
	private double balance;
	
	// 출금 메소드 
	public void debit(double debit) throws Exception{
		if(balance >= debit) {
			//System.out.printf("Substracting %f from %s balance\n", debit, name);
			balance -= debit;
		} else {
			//System.out.printf("Substracting %f from %s balance\n", debit, name);
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
	public Account(double bal) {
		balance = bal;
	}
	
	// 추상 메소드
	public abstract void passTime(int a);
	public abstract void passTime();
	public abstract double getWithdrawableAccount();

}
