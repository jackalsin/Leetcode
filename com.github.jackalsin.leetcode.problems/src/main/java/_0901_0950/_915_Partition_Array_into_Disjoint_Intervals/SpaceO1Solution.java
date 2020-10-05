package _0901_0950._915_Partition_Array_into_Disjoint_Intervals;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SpaceO1Solution implements Solution {
  @Override
  public int partitionDisjoint(int[] A) {
    final int n = A.length;
    int leftPartitionMax = A[0],
        maxEndHere = A[0],
        leftPartitionEnd = 0;
    for (int i = 1; i < n; ++i) {
      maxEndHere = Math.max(maxEndHere, A[i]);
      if (A[i] < leftPartitionMax) { // this possible right min must be included in the left
        leftPartitionEnd = i;
        leftPartitionMax = maxEndHere;
      }
    }
    return leftPartitionEnd + 1;
  }
}
