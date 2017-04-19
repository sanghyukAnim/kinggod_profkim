// 0.1 int
// 0.7 loan int


package account;

public class CheckingAccount extends Account {
	private double credit_limit;
	private double interest;
	private double loan_interest;

	private double temp;
	
	public CheckingAccount(int a, int b, double c, double d) {
		super(a);
		credit_limit = b;
		interest = c;
		loan_interest = d;
	}
	
	
	public double getWithdrawableAccount() {
		if(super.getBalance() + credit_limit < 0) {
			return 0;
		} else {
			return super.getBalance() + credit_limit;
		}
	}
	
	@Override public void debit(double a) throws Exception{
		if(a>getWithdrawableAccount()) throw new Exception("Debit amount exceeded account balance\n");
		if(a < 0) throw new Exception("음수입력!\n");
		else {super.setBalance(super.getBalance() - a);}
	}
	
	public void nextMonth() {
		if(getBalance() > 0) {
			temp = getBalance() * (1 + this.interest);
			super.setBalance(temp);
		} else if(super.getBalance() < 0) {
			temp = super.getBalance() * (1 + this.loan_interest);
			super.setBalance(temp);
		}
	}
	
	public boolean isBankrupted() {
		if(getWithdrawableAccount() < 0) {
			return false;
		} else {
			return true;
		}
	}
	public void passTime(int a) {
		int i;
		for(i=0; i<a; i++) {
			nextMonth();
		}
	}
	public void passTime() {
		passTime(1);
	}
	
	public String toString() {
		return String.format("CheckingAccount_Balance: %.2f\n", super.getBalance());
	}
	
	public double estimateValue(int month) {
		passTime(month);
		return super.getBalance();
	}
	public double estimateValue() {
		return estimateValue(1);
	}
}
