package Vika8;

public class Point implements Comparable<Point> {
    Long x;
    Long y;

    public Point(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x.equals(point.x) && y.equals(point.y);
    }

    @Override
    public int hashCode() {
        return 31 * x.hashCode() + y.hashCode();
    }

    @Override
    public int compareTo(Point other) {
        int cmp = this.x.compareTo(other.x);
        if (cmp != 0) return cmp;
        return this.y.compareTo(other.y);
    }
}
