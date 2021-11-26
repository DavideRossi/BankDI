package it.unibo.sweng.bankdi;

public class Main {
	
	public static void main(String[] args) {
		RemoteBankOperator remoteBankOperator = new SETRemoteBankOperator();
		TransactionLogger transactionLogger = new FileTransactionLogger();
		TransferManager transferManager = new TransferManager(remoteBankOperator, transactionLogger);
		Account account = Account.AccountBuilder.createBuilder().setOwner("Superpippo").setBalance(100).build();
		transferManager.makeTransfer(account, "ITXYZ42", 50);
	}
}
