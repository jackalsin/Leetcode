package _0551_0600._563_Binary_Tree_Tilt;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
public final class SolutionI implements Solution {
  private int tilt = 0;

  public int findTilt(TreeNode root) {
    findTiltHelper(root);
    return tilt;
  }

  private int findTiltHelper(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int leftSum = findTiltHelper(root.left),
        rightSum = findTiltHelper(root.right);
    tilt += Math.abs(rightSum - leftSum);
    return leftSum + rightSum + root.val;
  }
}
