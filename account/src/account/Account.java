package account;

import java.util.Scanner;

public class Account {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double credit = 0.0;
		double debit;
		int choose = 0;		// 계좌 선택 
		int chooose = 0;	// 입금/출금 선택 
	
		// 1번 계좌 초기금액 설정 
		System.out.print("deposit account1: ");
		credit = input.nextDouble();
		Balance a = new Balance(credit, "account1");
		
		// 2번 계좌 초기금액 설정 
		System.out.print("deposit account2: ");
		credit = input.nextDouble();
		Balance b = new Balance(credit, "account2");
		
		System.out.printf("account1 balance: %f\n", a.getBalance());
		System.out.printf("account2 balance: %f\n", b.getBalance());
		
		while(true) {
			System.out.print("1.Deposit  2. Debit: ");
			chooose = input.nextInt();
			if(chooose == 1) {
				// 입금 계좌 선택 
				System.out.print("Choose account to deposit... 1.account1  2.account2 ");
				choose = input.nextInt();
				if(choose == 1) {
					// 1번 계좌에 입금 
					System.out.print("Enter deposit amount for account1: ");
					credit = input.nextDouble();
					a.deposit(credit);
				} else if(choose == 2) {
					// 2번 계좌에 입금 
					System.out.print("Enter deposit amount for account2: ");
					credit = input.nextDouble();
					b.deposit(credit);
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
					debit = input.nextDouble();
					a.withdraw(debit);
				} else if(choose == 2) {
					// 2번 계좌에서 출금 
					System.out.print("Enter withdrawal amount for account2: ");
					debit = input.nextDouble();
					b.withdraw(debit);
				}
			}else {
					// 예외처리 
				System.out.println("Error!");
				break;	// 단호한 종료 
			}
			
			// 잔액 출력
			System.out.printf("account1 balance: %f\n", a.getBalance());
			System.out.printf("account2 balance: %f\n", b.getBalance());
		}
		
	}

}
