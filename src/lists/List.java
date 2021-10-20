package lists;

import collections.Collection;

public interface List<T> extends Collection<T>, Iterable<T> {

	void add(int index, T item);
	void set(int index, T item);
	T get(int index);
	void remove(int index);
	int indexOf(T item);
	int size();
	
	
	
}