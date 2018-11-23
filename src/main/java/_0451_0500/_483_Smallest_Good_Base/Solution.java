package _0451_0500._483_Smallest_Good_Base;

public class Solution {

  /**
   * Assume n = 1+k^1+k^2+k^3+...+k^d
   * The bigger d is, the smaller k is.
   * <p>
   * https://discuss.leetcode.com/topic/76347/3ms-ac-c-long-long-int-binary-search/2
   *
   * @param n
   * @return
   */
  public String smallestGoodBase(String n) {
    final long nLong = Long.parseLong(n);
    for (int d = 63; d >= 1; d--) {
      if ((1 << d) >= nLong) continue;
      long base = isSolvableByD(nLong, d);
      if (base != 0) {
        return String.valueOf(base);
      }
    }
    return String.valueOf(nLong - 1);
  }

  /**
   * Return k where n = 1+k^1+k^2+k^3+...+k^d,
   * or 0 when no such k.
   *
   * @param n
   * @param d
   * @return
   */
  long isSolvableByD(final long n, final int d) {
    long left = 1, right = (long) Math.pow(n, 1d / d) + 1; // n > k^d => k < n ^ (1/d)

    while (left <= right) {
      long mid = (right - left) / 2 + left; // candidate of k
      long sum = getSum(mid, d);
      if (sum == n) {
        return mid;
      } else if (sum < n) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return 0;
  }

  private long getSum(long k, int d) {
    long sum = 1L, cur = k;
    for (int i = 1; i <= d; i++) {
      sum += cur;
      cur *= k;
    }
    return sum;
  }
}
