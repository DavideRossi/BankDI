package it.unibo.sweng.bankdi;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class BankModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RemoteBankOperator.class).to(RESTRemoteBankOperator.class);
		bind(new TypeLiteral<Factory<Notificator>>(){}).to(NotificatorFactory.class);
		bind(Notificator.class).annotatedWith(Email.class).to(EmailNotificator.class);
		bind(Notificator.class).annotatedWith(SMS.class).to(SMSNotificator.class);
	}
}
