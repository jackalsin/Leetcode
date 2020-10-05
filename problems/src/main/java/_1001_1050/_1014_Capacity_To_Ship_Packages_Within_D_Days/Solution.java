package _1001_1050._1014_Capacity_To_Ship_Packages_Within_D_Days;

public class Solution {
  public int shipWithinDays(int[] weights, int D) {

    int left = 0, right = Integer.MAX_VALUE;
    while (left < right) {
      final int mid = (left + right) / 2;
      if (isValid(weights, D, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private static boolean isValid(final int[] weights, final int D, final int cap) {
    int i = 0;
    for (int d = 0; d < D; d++) {
      int remain = cap;
      while (true) {
        if (i >= weights.length) break;
        if (weights[i] <= remain) {
          remain -= weights[i++];
        } else {
          break;
        }
      }
    }
    return i == weights.length;
  }
}
