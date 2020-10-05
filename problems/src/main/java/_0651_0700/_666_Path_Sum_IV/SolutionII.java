package _0651_0700._666_Path_Sum_IV;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/11/2020
 */
public final class SolutionII implements Solution {
  private final Map<Integer, Integer> indexToValue = new HashMap<>();
  private int sum = 0;

  public int pathSum(int[] nums) {
    buildMap(nums);
//    System.out.println(indexToValue);
    traverse(0, 0);
    return sum;
  }

  private void traverse(final int i, final int sum) {
    final int leftIndex = i * 2 + 1, rightIndex = 2 * i + 2, val = indexToValue.get(i);
    final boolean hasLeft = indexToValue.containsKey(leftIndex),
        hasRight = indexToValue.containsKey(rightIndex);
    if (hasLeft) {
      traverse(leftIndex, sum + val);
    }
    if (hasRight) {
      traverse(rightIndex, sum + val);
    }
    if (!hasLeft && !hasRight) {
      this.sum += sum + val;
    }
  }

  private void buildMap(final int[] nums) {
    for (final int num : nums) {
      final int depth = num / 100, bias = (num / 10) % 10 - 1, val = num % 10;
      final int index = (1 << (depth - 1)) + bias - 1;
      indexToValue.put(index, val);
    }
  }
}
