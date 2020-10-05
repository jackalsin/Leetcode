package _0551_0600._572_Subtree_of_Another_Tree;

import definition.binaryTree.TreeNode;

public class Solution {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    return isEquals(s, t) || (s != null &&
        (isSubtree(s.left, t) || isSubtree(s.right, t))
    );
  }

  private static boolean isEquals(final TreeNode s, final TreeNode t) {
    if (s == null && t == null) {
      return true;
    } else if (s == null || t == null) {
      return false;
    }

    return s.val == t.val && isEquals(s.left, t.left) && isEquals(s.right, t.right);
  }
}
