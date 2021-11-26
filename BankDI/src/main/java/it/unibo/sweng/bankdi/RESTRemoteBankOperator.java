package it.unibo.sweng.bankdi;

public class RESTRemoteBankOperator implements RemoteBankOperator {

	//perform a transaction with a remote back using REST
	@Override
	public boolean transfer(String destinationAccountCode, double amount) {
		System.out.println("REALLY REALLY transferring "+amount+" to "+destinationAccountCode+" using REST");
		return true;
	}
}
