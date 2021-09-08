package airbnb._875_Koko_Eating_Bananas;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/5/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int minEatingSpeed(int[] piles, int H) {
    int left = 1, right = Arrays.stream(piles).max().getAsInt();
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (count(piles, mid) <= H) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    assert (count(piles, left) <= H);
    return left;
  }

  private static int count(final int[] piles, final int h) {
    int res = 0;
    for (int p : piles) {
      res += p / h;
      if (p % h != 0) res++;
    }
    return res;
  }
}
