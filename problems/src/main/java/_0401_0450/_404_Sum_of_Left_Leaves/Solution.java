package _0401_0450._404_Sum_of_Left_Leaves;

import definition.binaryTree.TreeNode;

/**
 * 102 / 102 test cases passed.
 * Status: Accepted
 * Runtime: 9 ms
 */
public class Solution {
  private int sum = 0;

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return 0;
    }
    sumOfLeftLeaves(root, true);
    return sum;
  }

  public void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
    if (root == null) {
      return;
    } else if (root.left == null && root.right == null) {
      sum += isLeft ? root.val : 0;
    } else {
      sumOfLeftLeaves(root.left, true);
      sumOfLeftLeaves(root.right, false);
    }
  }
}
