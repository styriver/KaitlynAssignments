package collections;

public class ArrayCollection<T> implements Collection<T> {
	
	protected T[] items;
	protected int size;
	protected int capacity;
	
	public ArrayCollection(int cap){
		capacity = cap <= 0? 20 : cap; //if cap is = 0 give 20 or else use cap
		items = (T[]) new Object[capacity];
		size = 0;
		
	}
			
			
	@Override
	public void add(T item) {
		if(item == null || size == items.length)return; //always want to do this
		items[size] = item;
		size++;
		
			
	}

	@Override
	public void remove(T item) {
		if(item == null) return;
		for(int i = 0; i<size; i++) {
			if(items[i].equals(item)) {
				items[i] = items[size-1]; // points to the last item
				size--;
				break;
			}
			
		}
		
	}

	@Override
	public boolean contains(T item) {
		
		return false;
	}

	@Override
	public int size() {
		
		return size;
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i<size; i++) {
			str += items[i].toString() + " ";
		}
		return str + "]";
	}

}//ends class

