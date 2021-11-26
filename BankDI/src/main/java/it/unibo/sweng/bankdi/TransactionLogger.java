package it.unibo.sweng.bankdi;

public interface TransactionLogger {

	//log transactions to a file
	void logTransaction(String message);

}
