package _0851_0900._875_Koko_Eating_Bananas;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minEatingSpeed(int[] piles, int H) {
    assert piles.length >= 1;
    long sum = 0;
    int max = 0;
    for (int pile : piles) {
      if (pile > max) max = pile;
      sum += pile;
    }
    int left = (int) (sum / H + (sum % H == 0 ? 0 : 1)), right = max;
    while (left < right) {
      final int mid = left + (right - left) / 2,
          count = count(piles, mid);
      if (count > H) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  private static int count(int[] piles, final int val) {
    int count = 0;
    for (final int pile : piles) {
      count += pile / val;
      if (pile % val != 0) count++;
    }
    return count;
  }
}
