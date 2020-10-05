package _0801_0850._845_Longest_Mountain_in_Array;

/**
 * @author jacka
 * @version 1.0 on 9/4/2020
 */
public final class StateSolution implements Solution {
  @Override
  public int longestMountain(int[] A) {
    if (A.length < 3) return 0;
    int start = 0, max = 0;
    State state = State.HAS_NOT_MET_RISING;
    for (int i = 1; i < A.length; ++i) {
      if (state == State.HAS_NOT_MET_RISING) {
        if (A[i - 1] < A[i]) {
          state = State.RISING;
        } else {
          start = i;
        }
      } else if (state == State.RISING) {
        if (A[i - 1] < A[i]) {
          // keep expect rising
        } else if (A[i - 1] == A[i]) {
          start = i;
          state = State.HAS_NOT_MET_RISING;
        } else {
          state = State.DROP;
          System.out.println("start = " + start + ", end = " + i);
          max = Math.max(i - start + 1, max);
        }
      } else {
        if (A[i - 1] < A[i]) {
          start = i - 1;
          state = State.RISING;
        } else if (A[i - 1] == A[i]) {
          start = i;
          state = State.HAS_NOT_MET_RISING;
        } else {
          System.out.println("start = " + start + ", end = " + i);
          max = Math.max(i - start + 1, max);
        }
      }
    }
    return max;
  }

  private enum State {
    HAS_NOT_MET_RISING,
    RISING,
    DROP
  }
}
