package example.overrideEquals.violateLiskovSubstitutionPrinciple;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 6/29/2019
 */
public class Point {
  private static final Set<Point> UNIT_CIRCLE = new HashSet<>() {{
    add(new Point(1, 0));
    add(new Point(-1, 0));
    add(new Point(0, 1));
    add(new Point(0, -1));
  }};

  private final int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static boolean onUnitCircle(Point p) {
    return UNIT_CIRCLE.contains(p);
  }

  @Override
  public boolean equals(Object o) {
// Broken - violate Liskov substitution principle
    if (o == null || o.getClass() != getClass()) return false;
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
