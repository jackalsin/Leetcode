package _101_150._101_Symmetric_Tree;

import utils.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/13/2017.
 */
public class Solution {
  public boolean isSymmetric(TreeNode root) {
    return recursive(root);
//    return iterative(root);
  }

  private static boolean recursive(TreeNode root) {
    return root == null || (root.left == null && root.right == null) || root.left != null && root
        .right != null && recursivelySymmetric(root.left, root.right);
  }

  private static boolean recursivelySymmetric(TreeNode tree1, TreeNode tree2) {
    return (tree1 == null && tree2 == null)
        || ((tree1 != null && tree2 != null) && tree1.val == tree2.val
        && recursivelySymmetric(tree1.left, tree2.right)
        && recursivelySymmetric(tree1.right, tree2.left));
  }
  private static boolean iterative(TreeNode root) {
    return false;
  }
}
