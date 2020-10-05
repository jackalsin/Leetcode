package _0951_1000._977_Squares_of_a_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] sortedSquares(int[] A) {
    if (A == null || A.length == 0) return A;
    final int[] result = new int[A.length];
    for (int left = 0, right = A.length - 1, k = A.length - 1; left <= right; --k) {
      if (Math.abs(A[left]) < Math.abs(A[right])) {
        result[k] = A[right] * A[right];
        right--;
      } else {
        result[k] = A[left] * A[left];
        left++;
      }
    }
    return result;
  }
}
