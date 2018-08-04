package interviews.facebook._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import utils.TreeNode;

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    final TreeNode left = lowestCommonAncestor(root.left, p, q),
        right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    } else if (left == null) {
      return right;
    } else {
      return left;
    }
  }
}
