package uber._945_inimum_Increment_to_Make_Array_Unique;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int minIncrementForUnique(int[] A) {
    Arrays.sort(A);
    int res = 0, need = 0;
    for (final int a : A) {
      res += Math.max(need - a, 0);
      need = Math.max(a + 1, need + 1);
    }
    return res;
  }
}
