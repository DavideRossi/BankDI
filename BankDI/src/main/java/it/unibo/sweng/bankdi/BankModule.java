package it.unibo.sweng.bankdi;

import com.google.inject.AbstractModule;

public class BankModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RemoteBankOperator.class).to(RESTRemoteBankOperator.class);
		bind(Notificator.class).to(EmailNotificator.class);
	}
}
