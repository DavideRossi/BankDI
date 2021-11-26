package it.unibo.sweng.bankdi;

public class EmailNotificator implements Notificator {

	@Override
	public void notify(Account account, String message) {
		System.out.println("REALLY REALLY sending email with text: \""+message+"\" to "+account.getEmail());
	}
}
