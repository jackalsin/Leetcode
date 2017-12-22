package utils;

import java.util.Objects;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/10/2017.
 */
public final class Point {
  public int x;
  public int y;
  public Point() {
    x = 0; y = 0;
  }
  public Point(int a, int b) {
    x = a;
    y = b;
  }

  @Override
  public String toString() {
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Point)) {
      return false;
    }
    Point point = (Point) o;
    return x == point.x &&
        y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
