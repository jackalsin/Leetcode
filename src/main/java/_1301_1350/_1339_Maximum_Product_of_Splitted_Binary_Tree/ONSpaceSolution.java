package _1301_1350._1339_Maximum_Product_of_Splitted_Binary_Tree;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
public final class ONSpaceSolution implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private final Set<Long> sums = new HashSet<>();

  public int maxProduct(TreeNode root) {
    final long totalSum = getSum(root);
    long max = 0;
    for (long cur : sums) {
      max = Math.max((totalSum - cur) * cur, max);
    }
    return (int) (max % MOD);
  }

  private long getSum(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final long sum = root.val + getSum(root.left) + getSum(root.right);
    sums.add(sum);
    return sum;
  }
}
