package interviews.linkedin._098_Validate_Binary_Search_Tree;

import utils.binaryTree.TreeNode;

public final class DfsSolution implements Solution {
  @Override
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  private static boolean isValidBST(final TreeNode root, final TreeNode small, final TreeNode big) {
    if (root == null) {
      return true;
    }
    if (small != null && root.val <= small.val) {
      return false;
    }
    if (big != null && root.val >= big.val) {
      return false;
    }
    return isValidBST(root.left, small, root)
        && isValidBST(root.right, root, big);
  }
}
