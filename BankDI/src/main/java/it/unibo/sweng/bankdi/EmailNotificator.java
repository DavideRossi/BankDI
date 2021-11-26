package it.unibo.sweng.bankdi;

public class EmailNotificator {

	public void notify(Account account, String message) {
		System.out.println("REALLY REALLY sending email with text: \""+message+"\" to "+account.getEmail());
	}
}
