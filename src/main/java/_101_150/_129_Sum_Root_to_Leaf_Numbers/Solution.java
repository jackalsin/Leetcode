package _101_150._129_Sum_Root_to_Leaf_Numbers;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  private int sum;
  public int sumNumbers(TreeNode root) {
    sum = 0;
    return recursion(root);
//    return iteration(root);
  }

  private int recursion(TreeNode root) {
    if (root == null) return 0;
    pathSum(root, 0);
    return sum;
  }

  private void pathSum(TreeNode root, int pathSum) {
    pathSum = pathSum * 10 + root.val;
    if (root.left == null && root.right == null) {
      sum += pathSum;
    } else {
      if (root.left != null) {
        pathSum(root.left, pathSum);
      }
      if (root.right != null) {
        pathSum(root.right, pathSum);
      }
    }
  }


}
