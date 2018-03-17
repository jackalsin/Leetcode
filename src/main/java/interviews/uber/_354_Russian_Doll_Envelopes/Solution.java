package interviews.uber._354_Russian_Doll_Envelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 3/15/2018.
 */
public class Solution { // TODO:
  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, new Comparator<>() {
      @Override
      public int compare(final int[] x, final int[] y) {
        int cmp = Integer.compare(x[0], y[0]);
        if (cmp == 0) {
          return Integer.compare(x[1], y[1]);
        }
        return cmp;
      }
    });

    int count = 0, prevWidth = 0, prevHeight = 0;
    for (final int[] e : envelopes) {
      if (e[0] > prevWidth && e[1] > prevHeight) {
        count++;
        prevWidth = e[0];
        prevHeight = e[1];
      }
    }
    return count;
  }
}
