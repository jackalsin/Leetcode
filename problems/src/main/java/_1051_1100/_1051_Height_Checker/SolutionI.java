package _1051_1100._1051_Height_Checker;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int heightChecker(int[] heights) {
    final int[] sorted = heights.clone();
    Arrays.sort(sorted);
    int res = 0;
    for (int i = 0; i < heights.length; ++i) {
      if (heights[i] != sorted[i]) res++;
    }
    return res;
  }
}
