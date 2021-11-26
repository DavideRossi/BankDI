package it.unibo.sweng.bankdi;

public class Account {
	private double balance;
	private int id;
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public boolean withdraw(double amount) {
		if(this.balance - amount >= 0) {
			this.balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "{Account id:"+this.id+", balance:"+balance+"}";
	}
}
