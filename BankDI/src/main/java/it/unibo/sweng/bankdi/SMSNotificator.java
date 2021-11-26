package it.unibo.sweng.bankdi;

public class SMSNotificator implements Notificator {

	@Override
	public void notify(Account account, String message) {
		System.out.println("REALLY REALLY sending SMS with text: \""+message+"\" to "+account.getPhoneNumber());
	}
}
