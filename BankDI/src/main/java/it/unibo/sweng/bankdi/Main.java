package it.unibo.sweng.bankdi;

public class Main {
	
	public static void main(String[] args) {
		TransferManager transferManager = new TransferManager();
		Account account = new Account(123, 100);
		transferManager.makeTransfer(account, "ITXYZ42", 50);
	}
}
