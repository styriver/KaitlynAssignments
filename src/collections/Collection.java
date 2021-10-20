package collections;

public interface Collection<T> {
	void add(T item);
	void remove(T item);
	boolean contains(T item);
	int size();
	

}

