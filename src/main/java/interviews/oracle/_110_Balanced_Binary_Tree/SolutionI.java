package interviews.oracle._110_Balanced_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isBalancedHelper(root).result;
  }

  private static Result isBalancedHelper(TreeNode root) {
    if (root == null) {
      return new Result(true, 0);
    }
    final Result left = isBalancedHelper(root.left),
        right = isBalancedHelper(root.right);
    final int height = 1 + Math.max(left.height, right.height);
    final boolean res = left.result && right.result && Math.abs(left.height - right.height) <= 1;
    return new Result(res, height);
  }

  private static final class Result {
    private final boolean result;
    private final int height;

    private Result(boolean result, int height) {
      this.result = result;
      this.height = height;
    }
  }
}
