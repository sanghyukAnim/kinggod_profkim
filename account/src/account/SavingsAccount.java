package account;

public class SavingsAccount extends Account {
	private double interest;
	private int month = 0;	// 월수 계산해서 출금여부 판단에사
	private double savingBalance;
	
	public void debit(double debit) throws Exception {
		if(month < 12) throw new Exception("아직 출금할 수 없습니다!\n ");
		if(debit < 0) throw new Exception("음수입력!\n");
		else {super.setBalance(super.getBalance() - debit);}
	}
	
	public SavingsAccount(int a, double b) {
		super(a);
		interest = b;
		savingBalance = a;
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
	public void passTime() {
		passTime(1);
	}
	// 추상 메소
	public double getWithdrawableAccount() {
		if(month < 12) {
			return 0.0;
		} else {
			return super.getBalance();
		}
	}
	
	public double estimateValue(int month) {
		passTime(month);
		return super.getBalance();
	}
	public double estimateValue() {
		return estimateValue(1);
	}
	
	@Override public double getBalance() {
		if(month < 12) {
			return savingBalance;
		} else {
			return super.getBalance();
		}
	}
}
