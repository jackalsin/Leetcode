package _851_900._896_Monotonic_Array;

public class Solution {
  public boolean isMonotonic(int[] A) {
    if (A == null || A.length <= 2) {
      return true;
    }
    boolean isInc = true, isDec = true;
    for (int i = 1; i < A.length; ++i) {
      isInc &= A[i - 1] <= A[i];
      isDec &= A[i - 1] >= A[i];
    }

    return isInc || isDec;
  }
}
