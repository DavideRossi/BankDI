package it.unibo.sweng.bankdi;

public class AccountNotificator {
	private Notificator notificator;
	
	public void notify(Account account, String message) {
		this.notificator.notify(account, message);
	}

}
