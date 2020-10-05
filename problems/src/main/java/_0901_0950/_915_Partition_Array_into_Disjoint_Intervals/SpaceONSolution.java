package _0901_0950._915_Partition_Array_into_Disjoint_Intervals;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SpaceONSolution implements Solution {
  @Override
  public int partitionDisjoint(int[] A) {
    final int n = A.length;
    final int[] minSinceHere = new int[n];
    Arrays.fill(minSinceHere, Integer.MAX_VALUE);
    minSinceHere[n - 1] = A[n - 1];
    for (int i = n - 2; i >= 0; --i) {
      minSinceHere[i] = Math.min(minSinceHere[i + 1], A[i]);
    }
    int maxEndHere = A[0];
    for (int i = 1; i < n; ++i) {
      if (maxEndHere <= minSinceHere[i]) {
        return i;
      }
      maxEndHere = Math.max(maxEndHere, A[i]);
    }
    throw new IllegalArgumentException("No such partition for " + Arrays.toString(A));
  }
}
