package lists;

import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle>

{
	public int compare(Rectangle r1, Rectangle r2) {
		int area1 = r1.getArea(), area2 = r2.getArea();

		/*if (area1 < area2) {
			return -1; // first Rectangle < second
		}
		if (area1 > area2) {
			return 1; // first Rectangle > second
		} else // the two areas are equal
		{
			return 0;
		}*/

		return (r1.getArea() - r2.getArea());

	}
}
