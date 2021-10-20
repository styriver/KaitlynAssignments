package collections;

public class Point implements Comparable<Point> {

	int x, y;

	public Point(int x, int y) {
		this.x = x; // this means current object
		this.y = y;

	}

	@Override
	public int compareTo(Point o) {
		if (x != o.x) {
			return x - o.x; // to go reverse order: high to low = -(x- 0.x) and -(y - o.y)
		} else {
			return y - o.y;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Point) || (o == null))
			return false;
		Point p = (Point) o;

		return x == p.x && y == p.y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
