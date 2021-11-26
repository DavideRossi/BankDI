package it.unibo.sweng.bankdi;

import com.google.inject.Inject;

public class NotificatorFactory implements Factory<Notificator> {
	@Inject @Email
	private Notificator emailNotificator;
	@Inject @SMS
	private Notificator smsNotificator;

	@Override
	public Notificator create(Object... objects) {
		if(!Account.class.isInstance(objects[0])) {
			throw new IllegalArgumentException("Account parameter expected");
		}
		Account account = Account.class.cast(objects[0]);
		if(account.getNotificationPreference() == NotificationType.EMAIL) {
			return this.emailNotificator;
		} else if(account.getNotificationPreference() == NotificationType.SMS) {
			return this.smsNotificator;
		} else {
			throw new IllegalArgumentException("Unsupported notification type");
		}
	}
}
