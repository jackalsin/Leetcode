package _0801_0850._845_Longest_Mountain_in_Array;

/**
 * @author jacka
 * @version 1.0 on 9/4/2020
 */
public final class GreedySolution implements Solution {
  @Override
  public int longestMountain(int[] A) {
    int max = 0, start = 0;
    while (start + 1 < A.length && A[start] >= A[start + 1]) {
      start++;
    }
    while (start < A.length) {

    }
    return max;
  }
}
