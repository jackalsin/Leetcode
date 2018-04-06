package _351_400._396_Rotate_Function;

import java.util.Arrays;

public class Solution {
  /**
   * 17 / 17 test cases passed.
   * Status: Accepted
   * Runtime: 4 ms
   *
   * @param A
   * @return
   */
  public int maxRotateFunction(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final int rightIndex = A.length - 1;
    int prevSum = 0, total = 0;
    for (int i = 0; i < A.length; i++) {
      prevSum += i * A[i];
      total += A[i];
    }
    int maxSum = prevSum;
    for (int i = A.length - 1; i >= 0; i--) {
      prevSum = prevSum - rightIndex * A[i] + total - A[i];
      maxSum = Math.max(maxSum, prevSum);
    }
    return maxSum;
  }
}
