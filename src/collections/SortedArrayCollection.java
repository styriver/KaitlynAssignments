package collections;

import java.util.Comparator;

public class SortedArrayCollection<T> implements Collection<T> {

	protected T[] items;
	protected int size;
	protected int capacity;
	protected Comparator<T> comp;

	public SortedArrayCollection(int cap, Comparator<T> comparator) {
		capacity = (cap <= 0) ? 20 : cap; // if cap is = 0 give 20 or else use cap
		items = (T[]) new Object[capacity];
		size = 0;
		this.comp = comparator;

	}

	@Override
	public void add(T item) {
		
		if (item == null || size >= items.length)
			return;
		if (!(item instanceof Comparable) && comp == null)
			return;

		Comparator<T> newComp = new Comparator<T>() {

			@Override // comp provided by user
			public int compare(T o1, T o2) {
				if (comp != null) {
					return comp.compare(o1, o2);
				} else {
					return ((Comparable<T>) o1).compareTo(o2);
				}
			}

		};

		// find insertion index
		int where = -1;
		for (int i = 0; i < size; i++) {

			// if( ( (Comparable<T>) items[i]).compareTo(item) >= 0) { // this is where you
			// stop when adding item in ascending order meaning the number should do before
			where = i;
			break;
			// }
		}

		if (where == -1) {
			items[size] = item;
			size++;
			return;
		}

		// clear a space
		for (int i = size; i > where; i--) {
			items[i] = items[i - 1];
		}

		// put item where it should be:
		items[where] = item;
		size++;

	}

	@Override
	public void remove(T item) {
		for (int i = 0; i < size; i++) {
			if (items[i].equals(item)) {
				for (int j = i; j < size - 1; j++) {
					items[j] = items[j + 1];
				}
				size--;
				break;
			}
		}
	}

	@Override
	public boolean contains(T item) {

		for (int i = 0; i < size; i++) {
			if (items[i].equals(item)) {
				return true;
			}

		}

		return false;
	}

	@Override
	public int size() {
	
		return size;
	}

	public String toString() {
		String str = "[";
		for (int i = 0; i < size; i++) {
			str += items[i].toString() + " ";
		}
		return str + "]";
	}

}// ends class
