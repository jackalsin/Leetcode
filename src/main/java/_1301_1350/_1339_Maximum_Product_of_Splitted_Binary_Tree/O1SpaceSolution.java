package _1301_1350._1339_Maximum_Product_of_Splitted_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
public final class O1SpaceSolution implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private long totalSum = 0, max = 0;

  public int maxProduct(TreeNode root) {
    totalSum = getSum(root);
    getSum(root);
    return (int) (max % MOD);
  }

  private long getSum(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final long sum = root.val + getSum(root.left) + getSum(root.right);
    max = Math.max((totalSum - sum) * sum, max);
    return sum;
  }
}
