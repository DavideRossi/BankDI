package it.unibo.sweng.bankdi;

public interface Factory<T> {

	T create(Object... objects);
}
