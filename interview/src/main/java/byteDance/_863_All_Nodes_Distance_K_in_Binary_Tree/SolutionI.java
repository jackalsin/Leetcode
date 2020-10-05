package byteDance._863_All_Nodes_Distance_K_in_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  private final List<Integer> result = new ArrayList<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    updateDown(target, K);
    updateUp(root, target, K);
    return result;
  }

  /**
   *
   */
  private int[] updateUp(final TreeNode root, final TreeNode target, final int k) {
    if (root == null) {
      return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    }
    if (root == target) {
      return new int[]{0, 0};
    }
    final int[] left = updateUp(root.left, target, k), right = updateUp(root.right, target, k);
    final int leftNormalized = getNormalized(left), rightNormalized = getNormalized(right);
    if (k == leftNormalized || rightNormalized == k) {
      result.add(root.val);
    }
    if (leftNormalized != Integer.MAX_VALUE) {
      updateDown(root.right, k - leftNormalized - 1);
    }
    if (rightNormalized != Integer.MAX_VALUE) {
      updateDown(root.left, k - rightNormalized - 1);
    }
    return new int[]{leftNormalized, rightNormalized};
  }

  private static int getNormalized(final int[] left) {
    int res = Math.min(left[0], left[1]);
    return res == Integer.MAX_VALUE ? Integer.MAX_VALUE : res + 1;
  }

  private void updateDown(final TreeNode root, int k) {
    if (root == null) {
      return;
    }
    if (k == 0) {
      result.add(root.val);
      return;
    }
    updateDown(root.left, k - 1);
    updateDown(root.right, k - 1);
  }
}
