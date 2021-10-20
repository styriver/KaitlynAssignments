package lists;
import collections.ArrayCollection;
import lists.List;

import java.util.Iterator;

public class ArrayList226<T> extends ArrayCollection<T> implements List<T> {

	public ArrayList226(int cap) {
		super(cap);
	}

	@Override
	public Iterator<T> iterator() {
		class LIterator implements Iterator<T>{
			int currentIndex;
			
			LIterator(){
				currentIndex = 0; 
			}
			
			@Override
			public boolean hasNext() {
				return currentIndex < size;
			}

			@Override
			public T next() {
				if(currentIndex >= size) return null;
				T hold = items[currentIndex];
				currentIndex++;
				
				return hold;
			}
			
		}
		return new LIterator();
	}

	@Override
	public void add(int index, T item) {
		if(item == null || index < 0 || index >= size || index >= items.length) {
			return;
		}
		
		T hold = items[index]; 
		items[index] = item;
		items[size] = hold;
		size++;
	}

	@Override
	public void set(int index, T item) {
		if(item == null || index < 0 || index >= size || index >= items.length) {
			return;
		}
		items[index] = item;
		
	}

	@Override
	public T get(int index) {
		if(index < 0 || index >= size) return null;
		return items[index];
	}

	@Override
	public void remove(int index) {
		if(index < 0 || index >= size) return;
		items[index] = items[size-1];
		size--;
		
	}

	@Override
	public int indexOf(T item) {
		if(item == null) return -1;
		for(int i = 0; i< size; i++) {
			if(items[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

}
