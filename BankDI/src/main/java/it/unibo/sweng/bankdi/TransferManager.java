package it.unibo.sweng.bankdi;

public class TransferManager {
	
	//transfer from a local account to a remote one
	public boolean makeTransfer(Account sourceAccount, String destinationAccountCode, double amount) {
		Notificator notificator = new EmailNotificator();
		RemoteBankOperator remoteBankOperator = new SETRemoteBankOperator();
		if(sourceAccount.getBalance() >= amount) {
			if(remoteBankOperator.transfer(destinationAccountCode, amount)) {
				sourceAccount.withdraw(amount);
				notificator.notify(
					sourceAccount,
					String.format("Trasferred %f from %s to %s", 
					amount, sourceAccount, destinationAccountCode));
				return true;
			} else {
				notificator.notify(
					sourceAccount,
					String.format("Failed to trasfer %f from %s to %s", 
					amount, sourceAccount, destinationAccountCode));
				return false;
			}
		} else {
			return false;
		}
	}
}
