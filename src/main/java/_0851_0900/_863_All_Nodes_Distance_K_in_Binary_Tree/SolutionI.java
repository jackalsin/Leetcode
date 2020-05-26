package _0851_0900._863_All_Nodes_Distance_K_in_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/11/2019
 */
public final class SolutionI implements Solution {
  private final List<Integer> result = new ArrayList<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    populateDown(target, K);
    populateUp(root, target, K);
    return result;
  }

  /**
   * Reverse look up to find the distance of the nodes is K
   *
   * @param root
   * @param target
   * @param K
   * @return
   */
  private int[] populateUp(final TreeNode root, final TreeNode target, final int K) {
    if (root == target) {
      return new int[]{0, 0};
    }
    if (root == null) {
      return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    }
    final int[] left = populateUp(root.left, target, K),
        right = populateUp(root.right, target, K);
    final int leftNormalized = getNormalized(left),
        rightNormalized = getNormalized(right);
    if (K == leftNormalized || K == rightNormalized) {
      result.add(root.val);
    }
    if (leftNormalized != Integer.MAX_VALUE) { // go right
      populateDown(root.right, K - leftNormalized - 1);
    } else if (rightNormalized != Integer.MAX_VALUE) {
      populateDown(root.left, K - rightNormalized - 1);
    }
    return new int[]{leftNormalized, rightNormalized};
  }

  private static int getNormalized(final int[] height) {
    int res = Math.min(height[0], height[1]);
    return res == Integer.MAX_VALUE ? res : res + 1;
  }

  /**
   * Check if there is any node below or self is distance k
   *
   * @param target
   * @param k
   */
  private void populateDown(final TreeNode target, final int k) {
    if (target == null) {
      return;
    }
    if (k == 0) {
      result.add(target.val);
      return;
    }
    populateDown(target.left, k - 1);
    populateDown(target.right, k - 1);
  }
}
