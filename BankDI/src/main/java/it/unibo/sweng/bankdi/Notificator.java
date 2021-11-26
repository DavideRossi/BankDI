package it.unibo.sweng.bankdi;

public interface Notificator {

	//notify an account owner
	void notify(Account account, String message);
}
