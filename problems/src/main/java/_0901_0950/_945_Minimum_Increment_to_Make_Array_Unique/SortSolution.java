package _0901_0950._945_Minimum_Increment_to_Make_Array_Unique;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/26/2020
 */
public final class SortSolution implements Solution {

  public int minIncrementForUnique(int[] A) {
    Arrays.sort(A);
    int res = 0, need = 0;
    for (int a : A) {
      res += Math.max(0, need - a);
      need = Math.max(need + 1, a + 1);
    }
    return res;
  }
}
