package account;

import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		/*
		Scanner input = new Scanner(System.in);
		
		double credit = 0.0;
		double deb;
		int choose = 0;		// 계좌 선택 
		int chooose = 0;	// 입금/출금 선택 
	
		// 1번 계좌 초기금액 설정 
		System.out.print("deposit account1: ");
		credit = input.nextDouble();
		CheckingAccount a = new CheckingAccount(credit, "account1");
		
		// 2번 계좌 초기금액 설정 
		System.out.print("deposit account2: ");
		credit = input.nextDouble();
		CheckingAccount b = new CheckingAccount(credit, "account2");
		
		System.out.printf("account1 balance: %f\n", a.getBalance());
		System.out.printf("account2 balance: %f\n", b.getBalance());
		
		while(true) {
			System.out.print("1.Deposit  2. Debit  3.Nextmonth: ");
			chooose = input.nextInt();
			if(chooose == 1) {
				// 입금 계좌 선택 
				System.out.print("Choose account to deposit... 1.account1  2.account2 ");
				choose = input.nextInt();
				if(choose == 1) {
					// 1번 계좌에 입금 
					System.out.print("Enter deposit amount for account1: ");
					credit = input.nextDouble();
					a.credit(credit);
				} else if(choose == 2) {
					// 2번 계좌에 입금 
					System.out.print("Enter deposit amount for account2: ");
					credit = input.nextDouble();
					b.credit(credit);
				} else {
					// 예외처리 
					System.out.println("Error!");
					break;	// 단호한 종료 
				}
			} else if(chooose == 2) {
				// 출금 계좌 선택
				System.out.print("Choose account to withdraw... 1.account1  2.account2 ");
				choose = input.nextInt();
				if(choose == 1) {
					// 1번 계좌에서 출금 
					System.out.print("Enter withdrawal amount for account1: ");
					deb = input.nextDouble();
					a.debit(deb);
				} else if(choose == 2) {
					// 2번 계좌에서 출금 
					System.out.print("Enter withdrawal amount for account2: ");
					deb = input.nextDouble();
					b.debit(deb);
				}
			}else if(chooose == 3) {
				System.out.println("next month!");
				a.nextMonth();
				b.nextMonth();
			} else {
			// 예외처리 
				System.out.println("Error!");
				break;	// 단호한 종료 
			}
			// 잔액 출력
			System.out.printf("account1 balance: %f\n", a.getBalance());
			System.out.printf("account2 balance: %f\n", b.getBalance());
		}
		*/
		CheckingAccount account1 = new CheckingAccount(100, 50, 0.01, 0.07);
		Account account2 = new SavingsAccount(100, 0.05);
		
		//Checking Account
		Scanner scan = new Scanner(System.in);
		double amount;
		
		System.out.printf("Account1 balance: $ %.2f \t현재출금가능액: %.2f\n", account1.getBalance(), account1.getWithdrawableAccount());
		System.out.println("Enter withdrawal amount for Account1: ");
		amount = scan.nextDouble();
		account1.debit(amount);
		System.out.printf("Account1 balance: $ %.2f \t현재출금가능액: %.2f\n", account1.getBalance(), account1.getWithdrawableAccount());
		// (a) 파산여부확인 (isBankrupt) - typecasting
		if( ((CheckingAccount)account1).isBankrupt() == -1) {
			System.out.println("account1 went Bankrupt!");
		}
		
		account1.passTime(1);
		System.out.printf("Account1 balance: $ %.2f \t현재출금가능액: %.2f\n", account1.getBalance(), account1.getWithdrawableAccount());
		// (a)
		if( ((CheckingAccount)account1).isBankrupt() == -1) {
			System.out.println("account1 went Bankrupt!");
		}
		
		account1.passTime(5);
		System.out.printf("Account1 balance: $ %.2f \t현재출금가능액: %.2f\n", account1.getBalance(), account1.getWithdrawableAccount());
		// (a)
		if( ((CheckingAccount)account1).isBankrupt() == -1) {
			System.out.println("account1 went Bankrupt!");
		}
		
		
		// Saving Account
		System.out.println();
		System.out.printf("Account2 balance: $ %.2f \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
		
		System.out.println("6 Month later!");
		account2.passTime(6);
		System.out.printf("Account2 balance: $ %.2f \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
		account2.debit(50);
		
		System.out.println("next 6 Month later!");
		account2.passTime(6);
		System.out.printf("Account2 balance: $ %.2f \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
		
		System.out.println("next 1 Month later!");
		account2.passTime(1);
		System.out.printf("Account2 balance: $ %.2f \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
		
		account2.debit(50);
		System.out.printf("Account2 balance: $ %.2f \t현재출금가능액: %.2f\n", account2.getBalance(), account2.getWithdrawableAccount());
	}
}
