package _0301_0350._333_Largest_BST_Subtree;

import utils.binaryTree.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/2/2017.
 */
public class Solution {
  private int max = 0;
  /**
   * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
   * Note:
   * A subtree must include all of its descendants.
   * Here's an example:
   *     10
   *    /  \
   *   5   15
   *  / \    \
   * 1   8    7
   * The Largest BST Subtree in this case is the highlighted one.
   * The return value is the subtree's size, which is 3.
   * @param root
   * @return
   */
  public int largestBSTSubtree(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      largestBstSubtree(root);
      return max;
    }
  }

  Result largestBstSubtree(TreeNode root) {
    if (root == null) {
      return new Result(0, Long.MAX_VALUE, Long.MIN_VALUE);
    } else {
      Result left = largestBstSubtree(root.left);
      Result right = largestBstSubtree(root.right);
      if (left.size == -1 || right.size == -1 || root.val <= left.max || root.val >= right.min) {
        return new Result(-1, Long.MAX_VALUE, Long.MIN_VALUE);
      } else {
        int size = left.size + right.size + 1;
        max = Math.max(size, max);
        return new Result(size, Math.min(left.min, root.val), Math.max(right.max, root.val));
      }
    }
  }

  private static class Result {
    private final int size;
    private final long max;
    private final long min;
    Result(int size, long min, long max) {
      this.size = size;
      this.max = max;
      this.min = min;
    }
  }
}
