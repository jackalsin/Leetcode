package _0901_0950._945_Minimum_Increment_to_Make_Array_Unique;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/26/2020
 */
public final class UnionFindSolution implements Solution {
  private final Map<Integer, Integer> roots = new HashMap<>();

  public int minIncrementForUnique(int[] A) {
    int res = 0;
    for (int a : A) {
      res += find(a) - a;
    }
    return res;
  }

  private int find(final int x) {
    final int result;
    if (roots.containsKey(x)) {
      result = find(roots.get(x) + 1);
    } else {
      result = x;
    }
    roots.put(x, result);
    return result;
  }
}
