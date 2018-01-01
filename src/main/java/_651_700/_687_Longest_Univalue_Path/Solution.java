package _651_700._687_Longest_Univalue_Path;

import utils.TreeNode;

public class Solution {
  private int max = 0;

  public int longestUnivaluePath(TreeNode root) {
    traverse(root);
    return max;
  }

  /**
   * @param curNode
   * @return {val, count}
   */
  private int[] traverse(TreeNode curNode) {
    if (curNode == null) {
      return new int[]{0, -1};
    } else {
      int[] left = traverse(curNode.left);
      int[] right = traverse(curNode.right);
      if (curNode.val == left[0] && curNode.val == right[0]) {
        int curMax = Math.max(left[1] + 1, right[1] + 1);
        max = Math.max(max, left[1] + 1 + right[1] + 1);
        return new int[]{left[0], curMax};
      } else if (curNode.val == left[0]) {
        max = Math.max(max, left[1] + 1);
        return new int[]{left[0], left[1] + 1};
      } else if (curNode.val == right[0]) {
        max = Math.max(max, right[1] + 1);
        return new int[]{right[0], right[1] + 1};
      } else {
        return new int[]{curNode.val, 0};
      }
    }
  }

}
