package _0651_0700._663_Equal_Tree_Partition;

import utils.binaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/9/2020
 */
public final class SolutionI implements Solution {
  private final Set<Integer> cache = new HashSet<>();

  public boolean checkEqualTree(TreeNode root) {
    final int left = checkEqualTreeHelper(root.left),
        right = checkEqualTreeHelper(root.right),
        sum = left + right + root.val;
    if (sum % 2 != 0) {
      return false;
    }
    return cache.contains(sum / 2);
  }

  private int checkEqualTreeHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = checkEqualTreeHelper(root.left),
        right = checkEqualTreeHelper(root.right),
        sum = left + right + root.val;
    cache.add(sum);
    return sum;
  }
}
