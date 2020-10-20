package _1001_1050._1022_Sum_of_Root_To_Leaf_Binary_Numbers;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/19/2020
 */
public final class SolutionI implements Solution {
  private int sum = 0;

  public int sumRootToLeaf(TreeNode root) {
    if (root == null) return 0;
    sumRootToLeaf(root, 0);
    return sum;
  }

  private void sumRootToLeaf(final TreeNode root, final int preSum) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      sum += preSum + root.val;
      return;
    }
    sumRootToLeaf(root.left, (preSum + root.val) * 2);
    sumRootToLeaf(root.right, (preSum + root.val) * 2);
  }
}
