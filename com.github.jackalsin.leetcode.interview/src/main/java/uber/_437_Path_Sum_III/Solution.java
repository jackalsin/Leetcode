package uber._437_Path_Sum_III;

import definition.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution {
  private final Map<Integer, Integer> preSumCount = new HashMap<>();

  /**
   * Time Complexity: O(N)
   * 126 / 126 test cases passed.
   * Status: Accepted
   * Runtime: 18 ms
   *
   * @param root
   * @param sum
   * @return
   */
  public int pathSum(TreeNode root, int sum) {
    preSumCount.put(0, 1);
    return pathSum(root, sum, 0);
  }

  private int pathSum(final TreeNode root, final int target, int curSum) {
    if (root == null) {
      return 0;
    }
    curSum += root.val;
    int count = preSumCount.getOrDefault(curSum - target, 0);

    preSumCount.put(curSum, preSumCount.getOrDefault(curSum, 0) + 1);
    count += pathSum(root.left, target, curSum);
    count += pathSum(root.right, target, curSum);
    preSumCount.put(curSum, preSumCount.getOrDefault(curSum, 0) - 1);
    return count;
  }
}
