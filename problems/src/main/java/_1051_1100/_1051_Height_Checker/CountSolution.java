package _1051_1100._1051_Height_Checker;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public final class CountSolution implements Solution {
  @Override
  public int heightChecker(int[] heights) {
    final int[] count = new int[101];
    for (final int h : heights) {
      count[h]++;
    }
    int res = 0;
    for (int i = 0, curHeight = 1; i < heights.length; ++i) {
      while (count[curHeight] == 0) {
        curHeight++;
      }
      if (curHeight != heights[i]) {
        res++;
      }
      count[curHeight]--;
    }
    return res;
  }
}
