package linkedin._671_Second_Minimum_Node_In_a_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionII implements Solution {

  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
      return -1;
    }
    if (root.left == null && root.right == null) {
      return -1;
    }
    assert root.left != null && root.right != null;
    int left = root.left.val, right = root.right.val;
    if (root.left.val == root.val) {
      left = findSecondMinimumValue(root.left);
    }
    if (root.right.val == root.val) {
      right = findSecondMinimumValue(root.right);
    }
    if (left != -1 && right != -1) {
      return Math.min(left, right);
    } else if (left != -1) {
      return left;
    } else if (right != -1) {
      return right;
    } else {
      return -1;
    }
  }
}
