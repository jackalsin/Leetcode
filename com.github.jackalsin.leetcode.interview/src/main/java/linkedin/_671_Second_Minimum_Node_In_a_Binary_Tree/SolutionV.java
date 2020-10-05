package linkedin._671_Second_Minimum_Node_In_a_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 7/26/2019
 */
public final class SolutionV implements Solution {
  @Override
  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
      return -1;
    }
    if (root.left == null) {
      assert root.right == null;
      return -1;
    }
    final int left = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val,
        right = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;

    return (left == -1 || right == -1) ?
        Math.max(left, right) : Math.min(left, right);
  }
}
