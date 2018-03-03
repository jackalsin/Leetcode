package interviews.google.rectangleRandomDistribute;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import utils.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/2/2018.
 */
class MultipleRectangleTest {

  private static final double BIAS = 0.05;

  @Test
  void testCase1() {
    final int[][] rects = {
        /* start, width, height*/
        {0, 2, 2},
        {3, 1, 3},
        {5, 2, 1}
    };
    final MultipleRectangle rectangles = new MultipleRectangle(rects);
    final Map<Point, Double> pointCount = new HashMap<>();
    final int N = 1_000_000;
    for (int i = 0; i < N; i++) {
      final Point point = rectangles.getPoint();
      pointCount.put(point, pointCount.getOrDefault(point, 0d) + 1d);
    }

    pointCount.entrySet().forEach(pointDoubleEntry -> pointDoubleEntry.setValue(pointDoubleEntry
        .getValue() / N));

    final double expected1 = 4d / 9d, expected2 = 1d / 3, expected3 = 2d / 9;
    double actual1 = 0, actual2 = 0, actual3 = 0;
    for (final Map.Entry<Point, Double> entry : pointCount.entrySet()) {
      final Point point = entry.getKey();
      final double p = entry.getValue();
      if (0 <= point.x && point.x <= 2) {
        actual1 += p;
      } else if (point.x <= 4 && point.x >= 3) {
        actual2 += p;
      } else {
        actual3 += p;
      }
    }
    assertEquals(expected1, actual1);
    assertEquals(expected2, actual2);
    assertEquals(expected3, actual3);
  }
}
