package linkedin._671_Second_Minimum_Node_In_a_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionI implements Solution {

  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
      return -1;
    }
    return minVal(root, root.val);
  }

  private int minVal(TreeNode root, int min) {
    if (root == null) {
      return -1;
    }
    if (root.val != min) {
      return root.val;
    }
    int left = minVal(root.left, min), right = minVal(root.right, min);
    if (left == -1) {
      return right;
    }
    if (right == -1) {
      return left;
    }
    return Math.min(left, right);
  }
}
