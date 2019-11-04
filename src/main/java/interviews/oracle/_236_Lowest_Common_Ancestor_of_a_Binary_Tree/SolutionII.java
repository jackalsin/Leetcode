package interviews.oracle._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class SolutionII implements Solution {
  @Override
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || q == root) {
      return root;
    }
    final TreeNode left = lowestCommonAncestor(root.left, p, q),
        right = lowestCommonAncestor(root.right, p, q);
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
