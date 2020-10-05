package _0651_0700._668_Kth_Smallest_Number_in_Multiplication_Table;

public class Solution {

  /**
   * Time Complexity O(log(m))
   */
  public int findKthNumber(int m, int n, int k) {
    int lo = 1, hi = m * n;
    while (lo <= hi) {
      int mid = (hi - lo) / 2 + lo;
      int count = getCount(mid, m, n);
      // 因为是小于等于mid 的count， count == k时，仍有可能是mid > target value, 因为此处mid不一定是存在于matrix中
      if (count >= k) {
        hi = mid - 1;
      } else if (count < k) {
        lo = mid + 1;
      }
    }
    return lo;
  }

  static int getCount(int mid, int m, int n) {
    int count = 0;
    for (int i = 1; i <= m; i++) {
      count += Math.min(mid / i, n);
    }
    return count;
  }
}
