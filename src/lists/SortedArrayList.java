package lists;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import collections.SortedArrayCollection;


public class SortedArrayList<T> extends SortedArrayCollection<T> implements Iterable<T>, List<T> {
//public class SortedArrayList<T> extends SortedArrayCollection<T> implements Iterable<T> {

// TODO Auto-generated constructor stub
	public SortedArrayList(int cap, Comparator<T> comparator) {
		super(cap, comparator);

	}

	// removes all, but one, copies of ‘item’ from the list:
	public void removeAllButOne(T item) {
		int counter = 0;
		for (int i = 0; i < size; i++) {
			if (items[i].equals(item)) {
				counter++;
				if (counter > 1) {
					remove(item);
				}

			}
		}

	}

	// set(...) should do nothing if index is at a position where ‘item’ would
	// destroy the order of the list
	@Override
	public void add(int index, T item)
		throws IndexOutOfBoundsException {
		System.out.println("here in add SortedArrayList add() method");
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

	// add(...) should do nothing if index is at a position where ‘item’ would
	// destroy the order of the list.
	public void set(int index, T item) {
		// TODO Auto-generated method stub

	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size)
			return null;
		return items[index];
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index >= size)
			return;
		items[index] = items[size - 1];
		size--;

	}

	@Override
	public int indexOf(T item) {
		if (item == null)
			return -1;
		for (int i = 0; i < size; i++) {
			if (items[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	public int size() {
		return size;
	}

	public Iterator<T> iterator() {
		class LIterator implements Iterator<T> {
			int currentIndex;

			LIterator() {
				currentIndex = 0;
			}

			@Override
			public boolean hasNext() {
				return currentIndex < size;
			}

			@Override
			public T next() {
				if (currentIndex >= size)
					return null;
				T hold = items[currentIndex];
				currentIndex++;

				return hold;
			}
		}
		return new LIterator();
	}

	public ListIterator<Rectangle> listIterator(int size) {
		// TODO Auto-generated method stub

		class LIterator implements ListIterator<T> {
			int currentIndex;
			int size;

			LIterator(int size) {
				currentIndex = size - 1;
				this.size = size;
			}

			@Override
			public boolean hasNext() {
				return currentIndex < size;
			}

			@Override
			public boolean hasPrevious() {
				return currentIndex >= 0;
			}

			@Override
			public T previous() {
				if (currentIndex >= size)
					return null;
				T hold = items[currentIndex];
				currentIndex--;

				return hold;
			}

			@Override
			public T next() {
				if (currentIndex >= size)
					return null;
				T hold = items[currentIndex];
				currentIndex++;

				return hold;
			}

			@Override
			public int previousIndex() {
				return currentIndex;
			}

			@Override
			public int nextIndex() {
				return 0;
			}

			@Override
			public void remove() {
				this.remove();
			}

			@Override
			public void set (T item) {
				this.set(item);
			}

			@Override
			public void add (T item) {
			   this.add(item);
			}
		}
		return (ListIterator<Rectangle>) new LIterator(size);

//		return null;
//		// Iterate in reverse.
//				List<Integer> lst = new ArrayList226<Integer>(10);
//				for (int i = lst.size(); i-- > 0;) {
//					System.out.println(lst.get(i));
//				}
	}

}