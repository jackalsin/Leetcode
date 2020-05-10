package interviews.byteDance._440_K_th_Smallest_in_Lexicographical_Order;

/**
 * @author jacka
 * @version 1.0 on 5/9/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int findKthNumber(int n, int k) {
    int cur = 1;
    --k;
    while (k > 0) {
      final int count = calSteps(n, cur, cur + 1);
      if (k >= count) {
        cur++;
        k -= count;
      } else {
        cur *= 10;
        k--; // remove self
      }
    }
    return cur;
  }

  private static int calSteps(final int n, long inclusive, long exclusive) {
    int count = 0;
    while (n >= inclusive) {
      count += Math.min(exclusive, n + 1) - inclusive;
      inclusive *= 10;
      exclusive *= 10;
    }
    return count;
  }
}
