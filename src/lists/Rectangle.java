package lists;

import java.util.Comparator;

public class Rectangle implements Comparator<Rectangle> {

	// define two fields
	private int length, width;

	// define no arg constructor
	Rectangle() {
		length = 1;
		width = 1;
	}

	// define parameterized constructor
	Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	// define a method to return area
	int getArea() {
		return (length * width);
	}

	// define a method to return Perimeter
	int getPerimeter() {
		return (2 * (length + width));
	}

	public String toString() {
		return "\n Rectangle [width=" + width + ", length=" + length + ", Area=" + getArea() + "]";
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;

		if (!(o instanceof Rectangle) || (o == null))
			return false;

		Rectangle p = (Rectangle) o;
		return length == p.length && width == p.width;
	}

	public int compare(Rectangle r1, Rectangle r2) {
		int diff = r1.getArea() - r2.getArea();

		if (diff < 0)
			return -1;
		else if (diff == 0)
			return 0;
		else
			return 1;
	}

}
