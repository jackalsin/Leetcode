package interviews.microsoft._101_Symmetric_Tree;

import utils.binaryTree.TreeNode;

public class Solution {
  public boolean isSymmetric(TreeNode root) {
    return root == null || (isSymmetric(root.left, root.right));
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    } else {
      return left.val == right.val
          && isSymmetric(left.left, right.right)
          && isSymmetric(right.left, left.right);
    }
  }
}
