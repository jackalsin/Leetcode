package interviews.byteDance._1339_Maximum_Product_of_Splitted_Binary_Tree;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private final Set<Long> sum = new HashSet<>();

  public int maxProduct(TreeNode root) {
    final long sum = this.sum(root);
    long res = Long.MIN_VALUE;
    for (final long s : this.sum) {
      final long cur = ((sum - s) * s);
      res = Math.max(cur, res);
    }
    return (int) (res % MOD);
  }

  private long sum(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final long left = sum(root.left), right = sum(root.right),
        sum = left + right + root.val;
    this.sum.add(sum);
    return sum;
  }
}
