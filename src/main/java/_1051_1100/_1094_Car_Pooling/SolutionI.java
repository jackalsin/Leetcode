package _1051_1100._1094_Car_Pooling;

/**
 * @author zhixi
 * @version 1.0 on 9/21/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean carPooling(int[][] trips, int capacity) {
    final int[] upAndDown = new int[1000 + 1];
    for (final int[] trip : trips) {
      final int people = trip[0], start = trip[1], end = trip[2];
      upAndDown[start] += people;
      upAndDown[end] -= people;
    }
    int cur = 0;
    for (int i = 0; i < 1001; ++i) {
      cur += upAndDown[i];
      if (cur > capacity) return false;
    }
    return true;
  }
}
