package it.unibo.sweng.bankdi;

public class FileTransactionLogger implements TransactionLogger {

	//log transactions to a file
	@Override
	public void logTransaction(String message) {
		System.out.println("REALLY REALLY logging \""+message+"\" to a file");
	}
}
