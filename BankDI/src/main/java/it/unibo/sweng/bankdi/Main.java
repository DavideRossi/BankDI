package it.unibo.sweng.bankdi;

public class Main {
	
	public static void main(String[] args) {
		//create a transfer manager
		TransferManager transferManager = new TransferManager(new EmailNotificator(), new SETRemoteBankOperator());

		//create a test account
		Account account = Account.AccountBuilder.createBuilder().
				setOwner("Superpippo").
				setEmail("super@pippo.com").
				setPhoneNumber("12345678").
				setBalance(100).
				build();

		//make a transfer
		transferManager.makeTransfer(account, "ITXYZ42", 50);
	}
}
