package _0401_0450._441_Arranging_Coins;

public class Solution {

  public int arrangeCoins(int n) {
    if (n == 0) {
      return 0;
    }
    int left = 1, right = Integer.MAX_VALUE;
    while (left < right) {
      final int mid = (right - left + 1) / 2 + left;
      final long sum = sum(mid);
      if (sum == n) {
        return mid;
      } else if (sum < n) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private long sum(int mid) {
    return (1 + (long) mid) * ((long) mid) / 2;
  }
}
