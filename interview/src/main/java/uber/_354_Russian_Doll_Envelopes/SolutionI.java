package uber._354_Russian_Doll_Envelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 3/15/2018.
 */
public final class SolutionI implements Solution {
  /**
   * 85 / 85 test cases passed.
   * Status: Accepted
   * Runtime: 22 ms
   */
  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, new Comparator<>() {
      @Override
      public int compare(final int[] x, final int[] y) {
        int cmp = Integer.compare(x[0], y[0]);
        if (cmp == 0) {
          return Integer.compare(y[1], x[1]);
        }
        return cmp;
      }
    });

    final int[] tails = new int[envelopes.length];
    if (envelopes.length == 0) {
      return 0;
    }
    int right = 0;
    tails[0] = envelopes[0][1];
    for (int i = 1, envelopesLength = envelopes.length; i < envelopesLength; i++) {
      int[] e = envelopes[i];
      int insertPoint = Arrays.binarySearch(tails, 0, right + 1, e[1]);
      if (insertPoint < 0) {
        insertPoint = -(insertPoint + 1);
      }

      tails[insertPoint] = e[1];
      if (insertPoint == right + 1) {
        right++;
      }
    }
    return right + 1;
  }
}
