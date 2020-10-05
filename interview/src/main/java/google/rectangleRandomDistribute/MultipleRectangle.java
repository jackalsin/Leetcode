package google.rectangleRandomDistribute;

import definition.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 3/1/2018.
 */
public final class MultipleRectangle implements Solution {
  private final Map<Integer, int[]> startPointToRectangles;
  private final TreeMap<Integer, int[]> preSum;
  private final Random random = new Random();
  private final int EXCLUSIVE_BOUND;

  public MultipleRectangle(final int[][] rectangles) {
    startPointToRectangles = new HashMap<>();
    preSum = new TreeMap<>();
    int areaSum = 0;
    for (final int[] rect : rectangles) {
      preSum.put(areaSum, rect);
      areaSum += rect[1] * rect[2];
      startPointToRectangles.put(rect[0], rect);
    }

    EXCLUSIVE_BOUND = areaSum + 1;
  }

  @Override
  public Point getPoint() {
    final int area = random.nextInt(EXCLUSIVE_BOUND);
    final Map.Entry<Integer, int[]> startPointToRect = preSum.floorEntry(area);
    final int[] rect = startPointToRect.getValue();
    int x = random.nextInt(rect[1] + 1), y = random.nextInt(rect[2] + 1);
    return new Point(rect[0] + x, y);
  }
}
