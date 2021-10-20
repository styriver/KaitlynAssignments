package lists;

import collections.LinkedCollection;
import collections.Node;

import java.util.*;

public class SortedLinkedList<T> extends LinkedCollection<T> {
	Comparator<T> comp;
	
	SortedLinkedList(Comparator<T> c){
		super();
		comp = c;
	}
	


	@Override
	public void add(T item) {
		if(item == null) return;
		if( !(item instanceof Comparable) && comp == null) return;
		Comparator<T> newComp = new Comparator<T>() {

			@Override // comp provided by user
			public int compare(T o1, T o2) {
				if(comp != null) {
					return comp.compare(o1, o2);
				}
				else{
					return ((Comparable<T>) o1).compareTo(o2);
				}
			}
			
		};
		
		Node<T> newNode = new Node<T>(item);
		Node<T> precursor = null, cursor = head;
		if(cursor == null) {
			head = newNode;
			size++;
			return;
		}
		//find where to "add" takes place
		while(cursor != null) {
			if(newComp.compare(cursor.getInfo(), item) >= 0) {
				break;
			}
			precursor = cursor;
			cursor = cursor.getLink();
		}
		//add

		if(precursor == null) {
			newNode.setLink(cursor); 
			head = newNode;
			
		}
		else {
			newNode.setLink(cursor);
			precursor.setLink(newNode);
		}
		size++;
	}
	
	

}
