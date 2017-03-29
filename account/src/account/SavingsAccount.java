package account;

public class SavingsAccount extends Account {
	private double interest;
	private int month;
	
	public void debit(double debit) {
		if(month < 12) {
			System.out.println("아직 출금할 수 없습니다! ");
		} else {
			super.setBalance(super.getBalance() - debit);
		}
	}
	
	public SavingsAccount(int a, double b) {
		super(a);
		interest = b;
	}
	
	public void nextMonth() {
		if(month < 12) {
			super.setBalance( (super.getBalance()*(1+interest)) );
			month += 1;
		}
	}
	
	public void passTime(int a) {
		int i;
		for(i=0; i<a; i++) {
			nextMonth();
		}
	}
	public double getWithdrawableAccount() {
		if(month < 12) {
			return 0.0;
		} else {
			return super.getBalance();
		}
	}
}
