package it.unibo.sweng.bankdi;

public class Main {
	
	public static void main(String[] args) {
		RemoteBankOperator remoteBankOperator = new SETRemoteBankOperator();
		TransactionLogger transactionLogger = new FileTransactionLogger();
		TransferManager transferManager = new TransferManager(remoteBankOperator, transactionLogger);
		Account account = new Account(123, 100);
		transferManager.makeTransfer(account, "ITXYZ42", 50);
	}
}
