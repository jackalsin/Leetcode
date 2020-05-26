package interviews.linkedin._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class SolutionII implements Solution {
  @Override
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (p.val > q.val) {
      return lowestCommonAncestor(root, q, p);
    }
    if (q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else if (q.val == root.val) {
      return root;
    } else if (p.val < root.val && root.val < q.val) {
      return root;
    } else if (p.val == root.val) {
      return root;
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
  }
}
