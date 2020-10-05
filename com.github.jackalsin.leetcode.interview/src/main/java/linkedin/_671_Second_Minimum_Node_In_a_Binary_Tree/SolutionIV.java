package linkedin._671_Second_Minimum_Node_In_a_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 7/26/2019
 */
public final class SolutionIV implements Solution {
  private long small = Long.MAX_VALUE, secondSmall = Long.MAX_VALUE;

  public int findSecondMinimumValue(TreeNode root) {
    update(root);
    return secondSmall == Long.MAX_VALUE ? -1 : (int) secondSmall;
  }

  private void update(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      assert root.right != null;
      final int left = root.left.val, right = root.right.val;
      assert root.val == Math.min(left, right);
      if (left > root.val) {
        secondSmall = Math.min(secondSmall, left);
        update(root.right);
        return;
      } else if (right > root.val) {
        secondSmall = Math.min(secondSmall, right);
        update(root.left);
        return;
      }

    } // end of if

    assert (root.left == null && root.right == null)
        || (root.val == root.left.val && root.val == root.right.val);
    update(root.left);
    update(root.right);
  }
}
