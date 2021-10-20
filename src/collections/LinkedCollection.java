package collections;

public class LinkedCollection<T> implements Collection<T> {
	protected Node<T> head; //connects to everything
	protected int size;
	
	public LinkedCollection() {
		head = null;
		size = 0;
		
	}
	
	@Override
	public void add(T item) {
		if(item == null) return;
		Node<T> newNode = new Node<T>(item);
		newNode.setLink(head); // sets newNode to connect with the head making newNode in front
		head = newNode; //sets the first item as head == adds new number to front
		size++;
		
	}

	@Override
	public void remove(T item) {
		if(item == null) return;
		Node<T> cursor = head, precursor = null; //to begin with
		while(cursor != null) {
			if(cursor.getInfo().equals(item)) {
			if(precursor == null) {
				head = head.getLink(); //head points to second now
			}
			else {
				precursor.setLink(cursor.getLink());
			}
			size--;
			break;
		}
		//how to make cursor and precursor travel(move forward)
		precursor = cursor; //before updating
		cursor = cursor.getLink(); //sets cursor to head
		//does not take care of special cases like remove something in the beginning or end
		
	}
  }

	@Override
	public boolean contains(T item) {
		if(item == null) return false;
		Node<T> cursor = head;
		while(cursor != null) {
			if(cursor.getInfo().equals(item)) {
				return true;
			}
			cursor = cursor.getLink();
			
		}
		return false;
	}

	@Override
	public int size() {
		
		return size;
	}

	public String toString() {
		String str = "[";
		Node<T> cursor = head;
		while(cursor != null) {
			str += cursor.getInfo().toString() + " ";
			cursor = cursor.getLink();
		}
		return str + "]";
	}
	
}



