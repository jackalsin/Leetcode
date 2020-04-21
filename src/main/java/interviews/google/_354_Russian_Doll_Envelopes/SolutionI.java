package interviews.google._354_Russian_Doll_Envelopes;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/20/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0) {
      return 0;
    }
    // width is increasing, but if two widths are the same, the height is decreasing
    // after sorting, all envelopes are valid 'based on width', so we just binary search based on 'heights'
    // to choose 'some of them' to meet the requirement
    // Ex. after sorting: (1,3), (3,5), (6,8), (6,7), (8,4), (9,5)
    // transform to question find LIS: [3,5,8,7,4,5] => like '300. Longest Increasing Subsequence'
    Arrays.sort(envelopes, (x, y) -> {
      final int cmp = Integer.compare(x[0], y[0]);
      if (cmp != 0) {
        return cmp;
      }
      return Integer.compare(y[1], x[1]);
    });
//    System.out.println(Arrays.deepToString(envelopes));
    final int[] minTails = new int[envelopes.length + 1];
    minTails[1] = envelopes[0][1];
    int rightBoundary = 1;
    for (int i = 1; i < envelopes.length; ++i) {
      final int[] envelope = envelopes[i];
      int index = firstGreaterOrEquals(minTails, 1, rightBoundary, envelope);
//      System.out.print("index = " + index + ", ");
      minTails[index] = envelope[1];
      if (index > rightBoundary) {
        rightBoundary++;
      }
//      System.out.println(Arrays.toString(minTails) + ", rightBoundary = " + rightBoundary);
    }
    return rightBoundary;
  }

  /**
   * last index that envelopes[0][index] < target[1]
   */
  private static int firstGreaterOrEquals(final int[] minTails, final int start, final int end, final int[] target) {
    int left = start, right = end;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (minTails[mid] >= target[1]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (minTails[left] >= target[1]) {
      return left;
    }
    return end + 1;
  }
}
