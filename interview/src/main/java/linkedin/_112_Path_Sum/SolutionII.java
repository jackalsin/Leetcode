package linkedin._112_Path_Sum;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class SolutionII implements Solution {
  @Override
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return sum == root.val;
    }
    return hasPathSum(root.left, sum - root.val)
        || hasPathSum(root.right, sum - root.val);
  }
}
