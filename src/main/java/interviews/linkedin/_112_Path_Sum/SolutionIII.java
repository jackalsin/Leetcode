package interviews.linkedin._112_Path_Sum;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return root.val == sum;
    }
    return hasPathSum(root.left, sum - root.val)
        || hasPathSum(root.right, sum - root.val);
  }
}
