package _0951_1000._979_Distribute_Coins_in_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author zhixi
 * @version 1.0 on 10/4/2020
 */
public final class SolutionI implements Solution {
  private int cost = 0;

  public int distributeCoins(TreeNode root) {
    distributeCoinsHelper(root);
    return cost;
  }

  /**
   * @return the coin that the current node needs to give to its parent
   */
  private int distributeCoinsHelper(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = distributeCoinsHelper(root.left), right = distributeCoinsHelper(root.right);
    cost += Math.abs(left) + Math.abs(right);
    return root.val + left + right - 1;
  }
}
