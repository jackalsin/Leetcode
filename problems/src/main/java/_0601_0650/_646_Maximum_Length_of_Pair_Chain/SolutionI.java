package _0601_0650._646_Maximum_Length_of_Pair_Chain;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/8/2020
 */
public final class SolutionI implements Solution {

  public int findLongestChain(int[][] pairs) {
    if (pairs == null || pairs.length == 0) {
      return 0;
    }
    Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
    int count = 1, prevEnd = pairs[0][1];
    for (int i = 1, pairsLength = pairs.length; i < pairsLength; i++) {
      final int[] pair = pairs[i];
      final int a = pair[0], b = pair[1];
      if (prevEnd < a) {
        prevEnd = b;
        count++;
      }
    }
    return count;
  }
}
