package interviews.linkedin._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionIII implements Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    final TreeNode left = lowestCommonAncestor(root.left, p, q),
        right = lowestCommonAncestor(root.right, p, q);
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
