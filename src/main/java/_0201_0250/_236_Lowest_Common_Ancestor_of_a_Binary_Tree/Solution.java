package _0201_0250._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/18/2017.
 */
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || q == root) {
      return root;
    } else {
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);
      if (left == null && right == null) {
        return null;
      } else if (left == null && right != null) {
        return right;
      } else if (left != null && right == null) {
        return left;
      } else {
        return root;
      }
    }
  }
}
