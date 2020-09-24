package _0901_0950._938_Range_Sum_of_BST;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 9/23/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int rangeSumBST(TreeNode root, int L, int R) {
    if (root == null) {
      return 0;
    } else if (root.val < L) {
      return rangeSumBST(root.right, L, R);
    } else if (root.val > R) {
      return rangeSumBST(root.left, L, R);
    } else {
      return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
  }
}
