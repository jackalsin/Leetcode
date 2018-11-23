package _0451_0500._454_4Sum_II;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * 48 / 48 test cases passed.
   * Status: Accepted
   * Runtime: 141 ms
   * <p>
   * Time Complexity: O (N^2)
   * Space Complexity: O (N^2)
   *
   * @param A
   * @param B
   * @param C
   * @param D
   * @return
   */
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    final Map<Integer, Integer> sumCount = new HashMap<>();

    for (int i : A) {
      for (int j : B) {
        sumCount.put(i + j, sumCount.getOrDefault(i + j, 0) + 1);
      }
    }

    int result = 0;
    for (int i : C) {
      for (int j : D) {
        result += sumCount.getOrDefault(-(i + j), 0);
      }
    }
    return result;
  }
}
