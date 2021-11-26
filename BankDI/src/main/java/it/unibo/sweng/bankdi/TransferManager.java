package it.unibo.sweng.bankdi;

import com.google.inject.Inject;

public class TransferManager {
	private Notificator notificator;
	private RemoteBankOperator remoteBankOperator;
	
	@Inject
	TransferManager(Notificator notificator, RemoteBankOperator remoteBankOperator) {
		super();
		this.notificator = notificator;
		this.remoteBankOperator = remoteBankOperator;
	}

	//transfer from a local account to a remote one
	public boolean makeTransfer(Account sourceAccount, String destinationAccountCode, double amount) {
		if(sourceAccount.getBalance() >= amount) {
			if(this.remoteBankOperator.transfer(destinationAccountCode, amount)) {
				sourceAccount.withdraw(amount);
				this.notificator.notify(
					sourceAccount,
					String.format("Trasferred %f from %s to %s", 
					amount, sourceAccount, destinationAccountCode));
				return true;
			} else {
				this.notificator.notify(
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
