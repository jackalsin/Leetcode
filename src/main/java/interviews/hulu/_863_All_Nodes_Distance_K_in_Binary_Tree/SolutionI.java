package interviews.hulu._863_All_Nodes_Distance_K_in_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
public final class SolutionI implements Solution {
  private final List<Integer> result = new ArrayList<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    populateDown(target, K);
    populateUp(root, target, K);
    return result;
  }

  private int[] populateUp(final TreeNode root, final TreeNode target, final int k) {
    if (root == null) {
      return new int[]{-1, -1};
    }
    if (root == target) {
      return new int[]{0, 0};
    }
    final int[] left = populateUp(root.left, target, k),
        right = populateUp(root.right, target, k);
    final int leftNormalized = getNormalized(left),
        rightNormalized = getNormalized(right);
    if (k == leftNormalized || k == rightNormalized) {
      result.add(root.val);
    }
    if (leftNormalized == -1 && rightNormalized == -1) {
      return new int[]{-1, -1};
    } else if (leftNormalized == -1) {
      populateDown(root.left, k - rightNormalized - 1);
      return new int[]{-1, rightNormalized};
    } else if (rightNormalized == -1) {
      populateDown(root.right, k - leftNormalized - 1);
      return new int[]{leftNormalized, -1};
    } else {
      throw new IllegalArgumentException("Found target twice in " + root);
    }
  }

  private static int getNormalized(final int[] input) {
    final int depth = Math.max(input[0], input[1]);
    return depth == -1 ? depth : depth + 1;
  }

  private void populateDown(final TreeNode root, final int k) {
    if (root == null) {
      return;
    }
    if (k == 0) {
      result.add(root.val);
      return;
    }
    populateDown(root.left, k - 1);
    populateDown(root.right, k - 1);
  }
}
