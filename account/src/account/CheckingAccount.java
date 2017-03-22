// 0.1 int
// 0.7 loan int


package account;

public class CheckingAccount extends Account {
	private double credit_limit = 100.00;
	private double interest = 1.1;
	private double loan_interest = 1.7;
	private double total = credit_limit - super.getBalance();
	
	private double temp;
	
	public CheckingAccount(double a, String b) {
		super(a,b);
	}
	
	@Override public void debit(double a) {
		if(a>total) {
			System.out.println("Debit amount exceeded account balance\n");
		} else {
			super.setBalance(super.getBalance() - a);
		}
	}
	
	public void nextMonth() {
		if(getBalance() > 0) {
			temp = getBalance()*this.interest;
			super.setBalance(temp);
		} else if(super.getBalance() < 0) {
			temp = super.getBalance()*this.loan_interest;
			super.setBalance(temp);
		}
	}
	
}
