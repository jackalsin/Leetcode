package _0901_0950._944_Delete_Columns_to_Make_Sorted;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/26/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minDeletionSize(String[] A) {
    final Set<Integer> D = new HashSet<>();
    for (int i = 1; i < A.length; ++i) {
      final String prev = A[i - 1], cur = A[i];
      for (int j = 0; j < prev.length(); ++j) {
        if (prev.charAt(j) > cur.charAt(j)) {
          D.add(j);
        }
      }
    }
    return D.size();
  }
}
