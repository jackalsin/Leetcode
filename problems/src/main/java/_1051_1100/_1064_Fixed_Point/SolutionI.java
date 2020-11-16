package _1051_1100._1064_Fixed_Point;

/**
 * @author zhixi
 * @version 1.0 on 11/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int fixedPoint(int[] A) {
    if (A == null || A.length == 0) {
      return -1;
    }
    final int n = A.length;
    int left = 0, right = n - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (A[mid] < mid) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return A[left] == left ? left : -1;
  }
}
