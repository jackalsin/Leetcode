package interviews.uber._354_Russian_Doll_Envelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 1/13/2019.
 */
public final class SolutionII implements Solution {

  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0) {
      return 0;
    }
    Arrays.sort(envelopes, new Comparator<int[]>() {
      @Override
      public int compare(final int[] a, final int[] b) {
        int cmp = Integer.compare(a[0], b[0]);
        if (cmp == 0) {
          return Integer.compare(b[1], a[1]);
        }
        return cmp;
      }
    });

    final int[] tails = new int[envelopes.length];
    tails[0] = envelopes[0][1];
    int right = 0;
    for (int[] e : envelopes) {
      int insertPoint = getInsertionPoint(tails, e[1], right);
      tails[insertPoint] = e[1];
      if (insertPoint == right + 1) {
        right++;
      }
    }
    return right + 1;
  }

  private int getInsertionPoint(final int[] tails, final int target, int right) {
    final int insertPoint = Arrays.binarySearch(tails, 0, right + 1, target);
    if (insertPoint < 0) {
      return -(insertPoint + 1);
    }
    return insertPoint;
  }
}
