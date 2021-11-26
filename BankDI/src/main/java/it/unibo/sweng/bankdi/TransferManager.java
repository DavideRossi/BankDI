package it.unibo.sweng.bankdi;

import com.google.inject.Inject;

public class TransferManager {
	private RemoteBankOperator bankOperator;
	private Factory<Notificator> notificatorFactory;

	@Inject
	TransferManager(RemoteBankOperator bankOperator, Factory<Notificator> notificatorFactory) {
		super();
		this.bankOperator = bankOperator;
		this.notificatorFactory = notificatorFactory;
	}

	//transfer from a local account to a remote one
	public boolean makeTransfer(Account sourceAccount, String destinationAccountCode, double amount) {
		Notificator notificator = this.notificatorFactory.create(sourceAccount);
		if(sourceAccount.getBalance() >= amount) {
			if(this.bankOperator.transfer(destinationAccountCode, amount)) {
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
