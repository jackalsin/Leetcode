package interviews.byteDance._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == q || root == p) {
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
