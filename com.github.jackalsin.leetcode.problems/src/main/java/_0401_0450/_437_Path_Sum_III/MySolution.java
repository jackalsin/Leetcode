package _0401_0450._437_Path_Sum_III;

import utils.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MySolution implements Solution {
  private final Map<Integer, Integer> cache = new HashMap<>();

  /**
   * 126 / 126 test cases passed.
   * Status: Accepted
   * Runtime: 18 ms
   * <p>
   * Time Complexity: O(N)
   *
   * @param root
   * @param sum
   * @return
   */
  public int pathSum(TreeNode root, int sum) {
    cache.put(0, 1);
    return pathSum(root, sum, 0);
  }

  private int pathSum(final TreeNode root, final int target, int curSum) {
    if (root == null) {
      return 0;
    }
    curSum += root.val;
    int count = cache.getOrDefault(curSum - target, 0);
    cache.put(curSum, cache.getOrDefault(curSum, 0) + 1);

    count += pathSum(root.left, target, curSum);
    count += pathSum(root.right, target, curSum);
    cache.put(curSum, cache.get(curSum) - 1);
    return count;
  }

}

