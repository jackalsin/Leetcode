package interviews.linkedin._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
public final class SolutionI implements Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) {
      return lowestCommonAncestor(root, q, p);
    }
    if (root == null || root == q || root == p) {
      return root;
    }

    if (root.val < p.val) {
      return lowestCommonAncestor(root.right, q, p);
    } else if (root.val > q.val) {
      return lowestCommonAncestor(root.left, q, p);
    } else {
      return root;
    }
  }
}
