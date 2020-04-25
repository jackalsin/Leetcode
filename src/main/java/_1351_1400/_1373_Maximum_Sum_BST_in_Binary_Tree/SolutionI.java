package _1351_1400._1373_Maximum_Sum_BST_in_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 4/24/2020
 */
public final class SolutionI implements Solution {
  private int result = 0;

  public int maxSumBST(TreeNode root) {
    maxSumBSTHelper(root);
    return result;
  }

  private Result maxSumBSTHelper(final TreeNode root) {
    if (root == null) {
      return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
    }
    if (root.left == null && root.right == null) {
      result = Math.max(root.val, result);
      return new Result(root.val, root.val, root.val, true);
    } else if (root.left == null) { // root.right != null
      final Result right = maxSumBSTHelper(root.right);
      if (!right.isBst || (root.val >= right.left)) {
        return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE, false);
      }
      final int sum = root.val + right.sum;
      result = Math.max(sum, result);
      return new Result(sum, root.val, right.right, true);
    } else if (root.right == null) {
      final Result left = maxSumBSTHelper(root.left);
      if (!left.isBst || (root.val <= left.right)) {
        return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE, false);
      }
      final int sum = root.val + left.sum;
      result = Math.max(sum, result);
      return new Result(sum, left.left, root.val, true);
    } else {
      final Result left = maxSumBSTHelper(root.left),
          right = maxSumBSTHelper(root.right);
      if (!left.isBst || !right.isBst || left.right >= root.val || right.left <= root.val) {
        return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE, false);
      }
      final int sum = root.val + left.sum + right.sum;
      result = Math.max(result, sum);
      return new Result(sum, left.left, right.right, true);
    }
  }

  private static final class Result {
    private final int sum, left, right;
    private final boolean isBst;

    private Result(int sum, int left, int right, boolean isBst) {
      this.sum = sum;
      this.left = left;
      this.right = right;
      this.isBst = isBst;
    }
  }
}
