package _0951_1000._961_N_Repeated_Element_in_Size_2N_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int repeatedNTimes(int[] A) {
    final Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < A.length; i++) {
      if (visited.contains(A[i])) {
        return A[i];
      } else {
        visited.add(A[i]);
        if (visited.size() > 4) {
          visited.remove(A[i - 3]);
        }
      }
    }
    throw new IllegalArgumentException(Arrays.toString(A));
  }
}
