package interviews.linkedin.mianjing._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import utils.binaryTree.TreeNode;

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, final TreeNode p, final TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    final TreeNode left = lowestCommonAncestor(root.left, p, q), right = lowestCommonAncestor(root.right, p, q);
    if (left == null && right == null) {
      return null;
    } else if (left == null) {
      return right;
    } else if (right == null) {
      return left;
    } else {
      return root;
    }
  }

}
