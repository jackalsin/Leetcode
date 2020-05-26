package interviews.oracle._863_All_Nodes_Distance_K_in_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 11/2/2019
 */
public final class SolutionI implements Solution {
  private final List<Integer> result = new ArrayList<>();
  private static final int NOT_FOUND = -404;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    updateDown(target, K);
    updateUp(root, target, K);
    return result;
  }

  /**
   * Return the depth
   *
   * @param root
   * @param target
   * @param k
   * @return {depth to target or -1, depth to target or -1}
   */
  private int[] updateUp(final TreeNode root, final TreeNode target, final int k) {
    if (root == target) {
      return new int[]{0, 0};
    }
    if (root == null) {
      return new int[]{NOT_FOUND, NOT_FOUND};
    }
    final int[] left = updateUp(root.left, target, k),
        right = updateUp(root.right, target, k),
        result = {NOT_FOUND, NOT_FOUND};
    final int normLeft = getNorm(left), normRight = getNorm(right);
    if (k == normLeft + 1 || k == normRight + 1) {
      this.result.add(root.val);
    }
    if (normLeft != NOT_FOUND) {
      updateDown(root.right, k - 2 - normLeft);
      result[0] = normLeft + 1;
    } else if (normRight != NOT_FOUND) {
      updateDown(root.left, k - 2 - normRight);
      result[1] = normRight + 1;
    }
    return result;
  }

  private static int getNorm(final int[] dist) {
    if (dist[0] != NOT_FOUND) {
      return dist[0];
    }
    return dist[1];
  }

  private void updateDown(final TreeNode root, final int k) {
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
