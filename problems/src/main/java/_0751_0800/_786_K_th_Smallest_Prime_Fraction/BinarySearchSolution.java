package _0751_0800._786_K_th_Smallest_Prime_Fraction;

/**
 * The time complexity is computed as follows: the binary search loop will terminate when the count of elements no
 * greater than a candidate solution reaches K. This is guaranteed to happen when the size of the search range [l, r]
 * becomes smaller than the smallest absolute distance between any pair of fractions in the matrix, which is >=
 * 1/MAX^2. Since each iteration will reduce the search range by half, the binary search loop will terminate after at
 * most log(MAX^2) steps. Each iteration is done in linear time, therefore the total time complexity is O(n * log
 * (MAX^2)), which is equivalent to O(n * log(MAX)).
 * <p>
 * Time Complexity: O(n * log(max ^ 2))
 * Space Complexity: O(1)
 *
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class BinarySearchSolution implements Solution {
  @Override
  public int[] kthSmallestPrimeFraction(int[] A, int K) {
    final int n = A.length;
    double min = 0, max = A[n - 1];
    for (; min <= max; ) {
      final double mid = (min + max) / 2;
      int count = 0, p = A[0], q = A[n - 1];
      for (int row = 0, col = n - 1; row < n; ++row) {
        while (col >= 0 && A[col] > A[n - 1 - row] * mid) col--;
        count += (col + 1);
        // find the max that satisfies the condition
        if (col >= 0 && A[col] * q > p * A[n - 1 - row]) {
          p = A[col];
          q = A[n - 1 - row];
        }
      }
      if (count < K) {
        min = mid;
      } else if (count > K) {
        max = mid;
      } else {
        return new int[]{p, q};
      }
    }
    throw new IllegalStateException();
  }
}
