package it.unibo.sweng.bankdi;

public class SQLTransactionLogger implements TransactionLogger {

	@Override
	public void logTransaction(String message) {
		System.out.println("REALLY REALLY logging \"" + message + "\" to a SQL DBMS");
	}
}
