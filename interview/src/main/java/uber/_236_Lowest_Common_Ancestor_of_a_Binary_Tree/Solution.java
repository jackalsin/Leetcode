package uber._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    } else {
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

}
