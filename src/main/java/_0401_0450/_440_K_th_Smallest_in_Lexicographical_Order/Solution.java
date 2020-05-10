package _0401_0450._440_K_th_Smallest_in_Lexicographical_Order;

public class Solution {

  /**
   * @see
   * <a href='https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/discuss/92242/ConciseEasy-to-understand-Java-5ms-solution-with-Explaination'>Concise/Easy-to-understand Java 5ms solution with Explaination</a>
   */
  public int findKthNumber(int n, int k) {
    int cur = 1;
    k--;
    while (k > 0) {
      final int step = calculateSteps(n, cur, cur + 1);
      if (step <= k) {
        cur++;
        k -= step;
      } else {
        k--;
        cur *= 10;
      }
    }
    return cur;
  }

  /**
   * Calculate the steps that needs from <tt>cur</tt>(inclusive) to <tt>cur + 1</tt> (exclusive)
   * <p>
   * Long is for overflowing
   *
   * @param n
   * @param cur
   * @param curPlus1
   * @return
   */
  private static int calculateSteps(int n, long cur, long curPlus1) {
    int steps = 0;
    while (cur <= n) {
      if (curPlus1 <= n) {
        /*
         * curPlus1 should be included.
         */
        steps += curPlus1 - cur;
      } else {
        /*
         * Only partially is included [cur, n]
         */
        steps += n - cur + 1;
      }
      curPlus1 *= 10;
      cur *= 10;
    }
    return steps;
  }
}
