package _751_800._783_Minimum_Distance_Between_BST_Nodes;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/7/2018.
 */
public class Solution {
  private int bias = Integer.MAX_VALUE;

  /**
   * Time Complexity: O(N)
   */
  public int minDiffInBST(TreeNode root) {
    minDiffInBSTHelper(root);
    return bias;
  }

  private int[] minDiffInBSTHelper(TreeNode root) {
    if (root == null) {
      return null;
    }
    final int[] result = new int[2], left = minDiffInBSTHelper(root.left),
        right = minDiffInBSTHelper(root.right);

    if (left == null && right == null) {
      return new int[] {root.val, root.val};
    } else if (left == null) {
      bias = Math.min(bias, right[0] - root.val);
      result[0] = root.val;
      result[1] = right[1];
    } else if (right == null) {
      bias = Math.min(bias, root.val - left[1]);
      result[0] = left[0];
      result[1] = root.val;
    } else {
      bias = Math.min(bias, right[0] - root.val);
      bias = Math.min(bias, root.val - left[1]);
      result[0] = left[0];
      result[1] = right[1];
    }
    return result;
  }
}
