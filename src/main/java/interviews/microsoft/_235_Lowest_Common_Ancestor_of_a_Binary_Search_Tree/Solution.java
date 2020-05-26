package interviews.microsoft._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import utils.binaryTree.TreeNode;

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) {
      return lowestCommonAncestor(root, q, p);
    }

    if (root.val < p.val) {
      return lowestCommonAncestor(root.right, p, q);
    } else if (root.val == p.val) {
      return root;
    } else if (root.val < q.val) {
      return root;
    } else if (root.val == q.val) {
      return root;
    } else {
      return lowestCommonAncestor(root.left, p, q);
    }
  }
}
