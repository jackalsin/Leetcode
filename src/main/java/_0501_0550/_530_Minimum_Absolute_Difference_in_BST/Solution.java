package _0501_0550._530_Minimum_Absolute_Difference_in_BST;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int getMinimumDifference(TreeNode root) {
    if (root == null) return 0;
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || root != null) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (prev == null) {
          prev = root;
        } else {
          min = Math.min(min, root.val - prev.val);
          prev = root;
        }
        root = root.right;
      }
    }
    return min;
  }
}
