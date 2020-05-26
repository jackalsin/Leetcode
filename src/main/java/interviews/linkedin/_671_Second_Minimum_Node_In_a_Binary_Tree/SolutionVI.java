package interviews.linkedin._671_Second_Minimum_Node_In_a_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 9/14/2019
 */
public final class SolutionVI implements Solution {
  private long sec = Long.MAX_VALUE;

  public int findSecondMinimumValue(TreeNode root) {
    update(root);
    return (int) sec;
  }

  private void update(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      assert root.right != null;
      final int left = root.left.val, right = root.right.val;
      if (left > root.val) {
        sec = Math.min(sec, left);
        update(root.right);
        return;
      } else if (right > root.val) {
        sec = Math.min(sec, right);
        update(root.left);
        return;
      }
    }
    update(root.left);
    update(root.right);
  }
}
