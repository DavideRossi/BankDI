package it.unibo.sweng.bankdi;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	
	public static void main(String[] args) {
		//setup Guice
		Injector injector = Guice.createInjector(new BankModule());

		//ask Guice for an instance of TransferManager which will be injected with dependencies if needed
		TransferManager transferManager = injector.getInstance(TransferManager.class);

		//create a test account
		Account account = Account.AccountBuilder.createBuilder().
				setOwner("Superpippo").
				setEmail("super@pippo.com").
				setPhoneNumber("12345678").
				setBalance(100).
				build();

		//make a transfer
		transferManager.makeTransfer(account, "ITXYZ42", 50);
	}
}
