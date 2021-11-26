package it.unibo.sweng.bankdi;

import java.util.Optional;

public class Account {
	private static final int ID_LIMIT = 12345;

	public static class AccountBuilder {
		private Optional<String> owner = Optional.empty();
		private Optional<Double> balance = Optional.empty();
		private Optional<Integer> id = Optional.empty();

		public static AccountBuilder createBuilder() {
			return new AccountBuilder();
		}
		
		private AccountBuilder() {
		}
		
		public AccountBuilder setOwner(String owner) {
			this.owner = Optional.of(owner);
			return this;
		}

		public AccountBuilder setBalance(double balance) {
			this.balance = Optional.of(balance);
			return this;
		}

		public AccountBuilder setId(int id) {
			this.id = Optional.of(id);
			return this;
		}

		public Account build() {
			if(this.owner.isEmpty()) {
				throw new IllegalArgumentException("Owner must be set");
			}
			String owner = this.owner.get();
			int id = this.id.orElse((int)(Math.random() * ID_LIMIT));
			double balance = this.balance.orElse(.0);
			return new Account(owner, id, balance);
		}
	}
	private String owner;
	private double balance;
	private int id;
	
	private Account(String owner, int id, double balance) {
		this.owner = owner;
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
		return String.format("{Account id: %d, owner: %s, balance: %f}", this.id, this.owner, this.balance);
	}
}
