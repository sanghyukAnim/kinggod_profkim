package account;

public class SavingsAccount extends Account {
	private double interest;
	private int month;	// 월수 계산해서 출금여부 판단에사
	
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
	
	public String toString() {
		return String.format("SavingsAccount_Balance: %.2f\n", super.getBalance());
	}
	
	// 추상 메소드 
	public void passTime(int a) {
		int i;
		for(i=0; i<a; i++) {
			nextMonth();
		}
	}
	// 추상 메소
	public double getWithdrawableAccount() {
		if(month < 12) {
			return 0.0;
		} else {
			return super.getBalance();
		}
	}
	
	public double EstimateValue(int month) {
		passTime(month);
		return super.getBalance();
	}
}
