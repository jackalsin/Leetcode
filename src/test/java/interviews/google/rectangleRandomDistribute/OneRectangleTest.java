package interviews.google.rectangleRandomDistribute;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import utils.Point;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/1/2018.
 */
class OneRectangleTest {
  private OneRectangle oneRectangle;
  private static final double BIAS = 0.05;

  @Test
  void test10By10() {
    oneRectangle = new OneRectangle(new int[] {10, 10});
    final Map<Point, Integer> pointCounts = new HashMap<>();
    final int total = 1_000_000;
    for (int i = 0; i < total; i++) {
      final Point point = oneRectangle.getPoint();
      pointCounts.put(point, pointCounts.getOrDefault(point, 0) + 1);
    }
    final int expected = total / 10 / 10;
    for (final Map.Entry<Point, Integer> entry : pointCounts.entrySet()) {
      final int actual = entry.getValue();
      assertTrue(expected * BIAS >= Math.abs(expected - actual));
    }
  }


}
