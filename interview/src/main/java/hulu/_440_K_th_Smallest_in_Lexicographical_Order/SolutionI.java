package hulu._440_K_th_Smallest_in_Lexicographical_Order;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int findKthNumber(int n, int k) {
    int cur = 1;
    k--;
    while (k > 0) {
      final int count = getCount(n, cur, cur + 1);
      if (count <= k) {
        cur++;
        k -= count;
      } else {
        k--;
        cur *= 10;
      }
    }
    return cur;
  }

  /**
   * Returns the count from [cur, Math.min(nextCur, 1 + n))
   */
  private static int getCount(final int n, long cur, long nextCur) {
    int steps = 0;
    while (cur <= n) {
      final long curStep = Math.min(n + 1, nextCur) - cur;
      steps += curStep;
      cur *= 10;
      nextCur *= 10;
    }
    return steps;
  }
}
