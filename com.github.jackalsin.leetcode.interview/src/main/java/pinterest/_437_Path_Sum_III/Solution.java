package pinterest._437_Path_Sum_III;

import utils.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private int count = 0;

  public int pathSum(TreeNode root, int sum) {
    final Map<Integer, Integer> preSumCount = new HashMap<>();
    preSumCount.put(0, 1);
    pathSum(preSumCount, root, sum, 0);
    return count;
  }

  private void pathSum(final Map<Integer, Integer> preSumCount, final TreeNode root, final int target, int curSum) {
    if (root == null) {
      return;
    }

    curSum += root.val;
    count += preSumCount.getOrDefault(curSum - target, 0);
    preSumCount.put(curSum, preSumCount.getOrDefault(curSum, 0) + 1);
    pathSum(preSumCount, root.left, target, curSum);
    pathSum(preSumCount, root.right, target, curSum);
    preSumCount.put(curSum, preSumCount.get(curSum) - 1);
  }
}
