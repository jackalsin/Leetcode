package microsoft._333_Largest_BST_Subtree;

import utils.binaryTree.TreeNode;

public class Solution {
  private int maxSize = 0;

  private static final int[] INVALID = {0, 0, -1};

  public int largestBSTSubtree(TreeNode root) {

    final int[] minMaxSize = largestBSTSubtreeHelper(root);
    return maxSize;
  }

  /**
   * @param root
   * @return {minVal, maxVal, BST Size}
   * {0, 0, -1} when it's not a binary search
   * {0, 0, 0} when it's null
   */
  private int[] largestBSTSubtreeHelper(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0, 0};
    }
    final int[] left = largestBSTSubtreeHelper(root.left),
        right = largestBSTSubtreeHelper(root.right);
    if (left[2] == -1) {
      return INVALID;
    }
    if (right[2] == -1) {
      return INVALID;
    }
    if ((left[2] == 0 || left[1] < root.val) && (right[2] == 0 || root.val < right[0])) {
      final int size = left[2] + 1 + right[2];
      maxSize = Math.max(size, maxSize);
      return new int[]{left[2] == 0 ? root.val : left[0], right[2] == 0 ? root.val : right[1], left[2] + 1 + right[2]};
    }
    return INVALID;
  }

}
