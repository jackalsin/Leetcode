package _401_450._440_K_th_Smallest_in_Lexicographical_Order;

public class Solution {
  // TODO: validate in Leetcode
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
   *
   * @param n
   * @param cur
   * @param curPlus1
   * @return
   */
  private static int calculateSteps(int n, int cur, int curPlus1) {
    int steps = 0;
    while (cur <= n) {
      if (curPlus1 < n) {
        steps += curPlus1 - cur;
      } else {
        steps += n - cur + 1;
      }
      curPlus1 *= 10;
      cur *= 10;
    }
    return steps;
  }
}
