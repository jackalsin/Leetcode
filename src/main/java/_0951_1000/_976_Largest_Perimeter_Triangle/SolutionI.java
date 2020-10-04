package _0951_1000._976_Largest_Perimeter_Triangle;

import java.util.Arrays;

/**
 * @author zhixi
 * @version 1.0 on 10/4/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int largestPerimeter(int[] A) {
    Arrays.sort(A);
    final int n = A.length;
    for (int i = n - 1; i >= 2; --i) {
      final int a = A[i - 2], b = A[i - 1], c = A[i];
      if (a + b > c) {
        return a + b + c;
      }
    }
    return 0;
  }
}
