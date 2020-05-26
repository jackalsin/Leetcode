package interviews.pinterest._124_Binary_Tree_Maximum_Path_Sum;

import utils.binaryTree.TreeNode;

public class Solution {
  private int maxSum = Integer.MIN_VALUE;

  /**
   * 93 / 93 test cases passed.
   * Status: Accepted
   * Runtime: 3 ms
   * Time complexity: O(N)
   *
   * @param root
   * @return
   */
  public int maxPathSum(TreeNode root) {
    getMaxSumPath(root);
    return maxSum;
  }

  private int getMaxSumPath(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftMaxSum = getMaxSumPath(root.left), rightMaxSum = getMaxSumPath(root.right);
    leftMaxSum = leftMaxSum < 0 ? 0 : leftMaxSum;
    rightMaxSum = rightMaxSum < 0 ? 0 : rightMaxSum;
    maxSum = Math.max(maxSum, root.val + leftMaxSum + rightMaxSum);
    return Math.max(leftMaxSum, rightMaxSum) + root.val;
  }
}
