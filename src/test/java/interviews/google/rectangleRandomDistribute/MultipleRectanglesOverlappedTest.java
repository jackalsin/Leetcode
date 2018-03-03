package interviews.google.rectangleRandomDistribute;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleRectanglesOverlappedTest {
  private static final double BIAS = 0.05;

  @Test
  void testOnlineCase1() {

    // [0, 1, 3]
    // [1, 2, 4]
    // [2, 3, 3]
    // [3, 4, 0]
    // [4, 5, 2]
    // [5, 6, 4]
    final int[][] rects = {
        {0, 3, 3},
        {1, 2, 4},
        {4, 6, 2},
        {5, 6, 4}
    };
    final MultipleRectanglesOverlapped multipleRectangles = new MultipleRectanglesOverlapped(rects);
    final int TOTAL = 1_000_000;
    final Map<Integer, Integer> pointCounts = new HashMap<>();

    for (int i = 0; i < TOTAL; i++) {
      final MultipleRectanglesOverlapped.Point point = multipleRectangles.getPoint();
      final int x = (int) Math.floor(point.x);
      pointCounts.put(x, pointCounts.getOrDefault(x, 0) + 1);
    }
    assertEquals(3d / 16, (double) pointCounts.get(0) / TOTAL, BIAS);
    assertEquals(4d / 16, (double) pointCounts.get(1) / TOTAL, BIAS);
    assertEquals(3d / 16, (double) pointCounts.get(2) / TOTAL, BIAS);
//    assertEquals(0d / 16, (double) pointCounts.get(3) / TOTAL, BIAS);
    assertEquals(2d / 16, (double) pointCounts.get(4) / TOTAL, BIAS);
    assertEquals(4d / 16, (double) pointCounts.get(5) / TOTAL, BIAS);

  }
}