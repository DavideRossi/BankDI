package it.unibo.sweng.bankdi;

public class TransferManager {
	private RemoteBankOperator bankOperator;
	private TransactionLogger transactionLogger;

	public TransferManager(RemoteBankOperator bankOperator, TransactionLogger transactionLogger) {
		super();
		this.bankOperator = bankOperator;
		this.transactionLogger = transactionLogger;
	}

	//transfer from a local account to a remote one
	public boolean makeTransfer(Account sourceAccount, String destinationAccountCode, double amount) {
		if(sourceAccount.getBalance() >= amount) {
			if(this.bankOperator.transfer(destinationAccountCode, amount)) {
				sourceAccount.withdraw(amount);
				this.transactionLogger.logTransaction(
					String.format("Trasferred %f from %s to %s", 
					amount, sourceAccount.toString(), destinationAccountCode));
				return true;
			} else {
				this.transactionLogger.logTransaction(
					String.format("Failed to trasfer %f from %s to %s", 
					amount, sourceAccount.toString(), destinationAccountCode));
				return false;
			}
		} else {
			return false;
		}
	}
}
