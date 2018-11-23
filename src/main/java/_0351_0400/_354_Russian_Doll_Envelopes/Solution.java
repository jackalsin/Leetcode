package _0351_0400._354_Russian_Doll_Envelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/9/2017.
 */
public class Solution {
  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        if (i1[0] == i2[0]) {
          return Integer.compare(i2[1], i1[1]);
        } else {
          return Integer.compare(i1[0], i2[0]);
        }
      }
    });
    System.out.println(Arrays.deepToString(envelopes));
    final int[] dp = new int[envelopes.length];
    int len = 0;
    for (int[] envelope : envelopes) {
      int insertPoint  = Arrays.binarySearch(dp, 0, len, envelope[1]);
      if (insertPoint < 0) {
        insertPoint = - (insertPoint + 1);
      }
      dp[insertPoint] = envelope[1];
      if (insertPoint == len) len++;
    }
    return len;
  }
}
