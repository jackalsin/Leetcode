package _0251_0300._270_Closest_Binary_Search_Tree_Value;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/29/2017.
 */
public class Solution {
  public int closestValue(TreeNode root, double target) {
    if (root == null) return 0;
    else return closestValue(root, target, root.val, Math.abs(root.val - target));
  }

  private static int closestValue(TreeNode root, double target, int closet, double bias) {
    assert root != null;
    if (root.val == target) {
      return root.val;
    } else if (root.val < target && root.right != null) {
      if (bias > target - root.val) {
        bias = target - root.val;
        closet = root.val;
      }
      return closestValue(root.right, target, closet, bias);
    } else if(root.val > target && root.left != null) {
      if (bias > root.val- target) {
        bias = root.val- target;
        closet = root.val;
      }
      return closestValue(root.left, target, closet, bias);
    } else {
      return bias > Math.abs(root.val - target) ? root.val : closet;
    }
  }
}
