package _1401_1450._1402_Reducing_Dishes;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/23/2020
 */
public final class ON2O1Solution implements Solution {
  @Override
  public int maxSatisfaction(int[] satisfaction) {
    final int n = satisfaction.length;
    Arrays.sort(satisfaction);
//    System.out.println(Arrays.toString(satisfaction));
    int[] prev = new int[n + 1];
    int res = 0;
    for (int i = 0; i < n; ++i) {
      final int[] next = new int[n + 1];
      int max = Integer.MIN_VALUE;
      for (int j = i; j < n; ++j) {
        next[j + 1] = Math.max(max, prev[j] + (i + 1) * satisfaction[j]);
        max = Math.max(next[j + 1], max);
      }
      res = Math.max(res, next[n]);
      prev = next;
    }
    return res;
  }
}
