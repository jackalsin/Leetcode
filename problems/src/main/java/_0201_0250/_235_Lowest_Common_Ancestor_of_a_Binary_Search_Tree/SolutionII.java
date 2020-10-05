package _0201_0250._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 7/8/2019
 */
public final class SolutionII implements Solution {
  @Override
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //    All of the nodes' values will be unique.
    //    p and q are different and both values will exist in the BST.
    if (p.val > q.val) {
      return lowestCommonAncestor(root, q, p);
    }
    assert p.val <= q.val;
    while (true) {
      if (root == p && root == q) {
        return root;
      }
      if (p.val < root.val && q.val < root.val) {
        root = root.left;
      } else if (p.val > root.val && q.val > root.val) {
        root = root.right;
      } else {
        return root;
      }
    }
  }
}
