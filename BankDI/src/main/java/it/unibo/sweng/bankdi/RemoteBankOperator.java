package it.unibo.sweng.bankdi;

public interface RemoteBankOperator {

	//perform a transaction with a remote back
	boolean transfer(String destinationAccountCode, double amount);
}