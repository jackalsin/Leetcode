package _0401_0450._437_Path_Sum_III;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public final class SecondVisitSolution implements Solution {
  private final Map<Integer, Integer> cache = new HashMap<>();

  @Override
  public int pathSum(TreeNode root, int sum) {
    cache.put(0, 1);
    return pathSum(root, sum, 0);
  }

  private int pathSum(final TreeNode root, final int sum, int curSum) {
    if (root == null) {
      return 0;
    }
    curSum += root.val;
    int curCount = cache.getOrDefault(-sum + curSum, 0);
    cache.put(curSum, cache.getOrDefault(curSum, 0) + 1);

    curCount += pathSum(root.left, sum, curSum);
    curCount += pathSum(root.right, sum, curSum);

    cache.put(curSum, cache.get(curSum) - 1);
    return curCount;
  }
}
