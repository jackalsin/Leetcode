package _0651_0700._669_Trim_a_Binary_Search_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) {
      return null;
    }
    final TreeNode left = trimBST(root.left, L, R),
        right = trimBST(root.right, L, R);
    if (root.val < L) {
      return right;
    }
    if (root.val > R) {
      return left;
    }
    root.left = left;
    root.right = right;
    return root;
  }
}
