package _0901_0950._941_Valid_Mountain_Array;

/**
 * @author jacka
 * @version 1.0 on 9/26/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean validMountainArray(int[] A) {
    if (A == null || A.length <= 1) {
      return false;
    }
    final int n = A.length;
    int increaseEnd = 0, decreaseStart = n - 1;
    while (increaseEnd + 1 < n && A[increaseEnd] < A[increaseEnd + 1]) {
      ++increaseEnd;
    }
    while (decreaseStart - 1 >= 0 && A[decreaseStart - 1] > A[decreaseStart]) {
      --decreaseStart;
    }
    return increaseEnd > 0 && decreaseStart < n - 1 && increaseEnd == decreaseStart;
  }
}
