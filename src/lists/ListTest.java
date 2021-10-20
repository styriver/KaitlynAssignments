package lists;

import java.util.*;

public class ListTest {

	public static void main(String[] args) {

		System.out.println("--------------- Arg Rectangle Test-------------------");
		Rectangle rect1 = new Rectangle(15, 8);
		System.out.println("Test1 = " + rect1.toString());
		System.out.println("");

		System.out.println("---------------Test SortedArrayList-------------------");

		SortedArrayList<Rectangle> a1 = new SortedArrayList(10, new RectangleComparator());
		Rectangle rect3 = new Rectangle(12, 12);
		Rectangle rect4 = new Rectangle(4, 5);
		Rectangle rect5 = new Rectangle(1, 1);
		Rectangle rect6 = new Rectangle(6, 5);
		Rectangle rect7 = new Rectangle(7, 5);
		a1.add(0,rect3);
		a1.add(1,rect4);
		a1.add(2,rect5);
		a1.add(3,rect6);
		a1.add(4,rect7);
		System.out.println("Call to toString method: " + a1);
		System.out.println("Call to Size of ArrayList: " + a1.size());
		System.out.println("");

		System.out.println("---------------Test Equals and Compare -------------------");
		System.out.println("Call to equals method = " + rect3.equals(rect4));
		RectangleComparator comp = new RectangleComparator();
		System.out.println("Call to compare method");
		int compTest = comp.compare(rect3, rect4);
		if (compTest < 0) {
			System.out.println("Compare Rectangle area " + rect3.getArea() + " is less than  " + rect4.getArea());
		} else if (compTest > 0) {
			System.out.println("Compare Rectangle area " + rect3.getArea() + " is greater than  " + rect4.getArea());
		} else {
			System.out.println("Compare Rectangle area " + rect3.getArea() + " and " + rect4.getArea() + " are equal");
		}

		System.out.println("\n");
		System.out.println("---------------Test iterator Printing -------------------");
		System.out.print("Original contents of a1: ");
		Iterator<Rectangle> itr = a1.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}
			
		
		System.out.println("\n");
		System.out.print("After remove all: ");
		a1.removeAllButOne(rect6);
		ListIterator<Rectangle> itr2 = a1.listIterator(a1.size());
		while (itr2.hasPrevious()) {
			Object element = itr2.previous();
			System.out.print(element + " ");
		}
	}
}

//test SortedArrayList
// SortedArrayList<Rectangle> a1 = new SortedArrayList<Rectangle>(2);

// SortedArrayList<Rectangle> a1 = new SortedArrayList(10, (new
// IntComparator()));
// SortedArrayList<Rectangle> a1 = new SortedArrayList(10,(new IntComparator());
// SortedArrayList<Rectangle> a1 = new SortedArrayList(10, rect1);

// class RectangleComparator implements Comparator<Rectangle> {
//	// compare by ascending x, break ties by y
//		public int compare(Rectangle r1, Rectangle r2) {
//			if (r1.getArea() != r2.getArea()) {
//				return r1.getArea() - r2.getArea();
//			} else {
//				return r1.getArea() - r2.getArea();
//			}
//		}
//	}

//class IntComparator implements Comparator {
//	public int compare(Object firstObject, Object secondObject) {
//		System.out.println("in Comparator");
////		Rectangle r1 = (Rectangle) firstObject;
////		Rectangle r2 = (Rectangle) secondObject;
////
////		if (r1.equals(r2)) // passes test for equality
////		{
////			return 0; // the two rectangles are equal
////		} else // not equal
//			return -1;
//	}
//}

//class IntComparator implements Comparator<Rectangle> {
//	public int compare(Object o1, Object o2) {
//		//return -(o1 - o2); // normal order return ( o1 - o2 );
//	}
//}
