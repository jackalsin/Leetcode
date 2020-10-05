package _0251_0300._298_Binary_Tree_Longest_Consecutive_Sequence;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class Solution {
  private int max = 0;

  public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;
    max = 1;
    longestConsecutive(root.left, root.val, 1);
    longestConsecutive(root.right, root.val, 1);
    return max;
  }

  private void longestConsecutive(TreeNode root, int val, int count) {
    if (root != null) {
      if (root.val == val + 1) {
        count++;
        max = Math.max(count, max);
      } else {
        count = 1;
      }
      longestConsecutive(root.left, root.val, count);
      longestConsecutive(root.right, root.val, count);
    }
  }
}
