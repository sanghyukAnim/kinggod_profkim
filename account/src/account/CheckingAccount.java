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
	
	@Override public void debit(double a) {
		if(a>getWithdrawableAccount()) {
			System.out.println("Debit amount exceeded account balance\n");
		} else {
			super.setBalance(super.getBalance() - a);
		}
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
	
	public int isBankrupt() {
		if(getWithdrawableAccount() < 0) {
			return -1;
		} else {
			return 1;
		}
	}
	public void passTime(int a) {
		int i;
		for(i=0; i<a; i++) {
			nextMonth();
		}
	}

	
	
}
