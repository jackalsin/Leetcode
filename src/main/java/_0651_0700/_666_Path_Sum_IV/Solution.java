package _0651_0700._666_Path_Sum_IV;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private final Map<Integer, Integer> indexToValues = new HashMap<>();
  private int sum;

  public int pathSum(int[] nums) {
    buildMap(nums);
    traverse(0, 0);
    return sum;
  }

  private void traverse(final int index, final int preSum) {
    if (index > (1 << 4) - 1) {
      return; // seems can be remove;
    }
    final int leftIndex = 2 * index + 1, rightIndex = 2 * index + 2;
    boolean hasLeft = indexToValues.containsKey(leftIndex),
        hasRight = indexToValues.containsKey(rightIndex);

    final int curVal = indexToValues.get(index);
    if (!hasLeft && !hasRight) {
      sum += preSum + curVal;
    }
    if (hasLeft) {
      traverse(leftIndex, preSum + curVal);
    }
    if (hasRight) {
      traverse(rightIndex, preSum + curVal);
    }

  }

  private void buildMap(final int[] nums) {
    for (int num : nums) {
      final int val = num % 10, depth = num / 100, bias = (num - val) / 10 % 10 - 1;
      final int index = (1 << (depth - 1)) - 1 + bias;
      indexToValues.put(index, val);
    }
  }
}
