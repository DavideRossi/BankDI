package it.unibo.sweng.bankdi;

public class TransferManager {
	
	//transfer from a local account to a remote one
	public boolean makeTransfer(Account sourceAccount, String destinationAccountCode, double amount) {
		RemoteBankOperator bankOperator = new SETRemoteBankOperator();
		TransactionLogger transactionLogger = new FileTransactionLogger();

		if(sourceAccount.getBalance() >= amount) {
			if(bankOperator.transfer(destinationAccountCode, amount)) {
				sourceAccount.withdraw(amount);
				transactionLogger.logTransaction(
					String.format("Trasferred %f from %s to %s", 
					amount, sourceAccount.toString(), destinationAccountCode));
				return true;
			} else {
				transactionLogger.logTransaction(
					String.format("Failed to trasfer %f from %s to %s", 
					amount, sourceAccount.toString(), destinationAccountCode));
				return false;
			}
		} else {
			return false;
		}
	}
}
