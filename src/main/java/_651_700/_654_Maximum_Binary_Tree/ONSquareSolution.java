package _651_700._654_Maximum_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/31/2017.
 */
public final class ONSquareSolution implements Solution {

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return buildTree(nums, 0, nums.length - 1);
  }

  private TreeNode buildTree(final int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return new TreeNode(nums[start]);
    }
    int maxIndex = start, max = nums[start];
    for (int i = start + 1; i <= end; i++) {
      if (max < nums[i]) {
        maxIndex = i;
        max = nums[i];
      }
    }

    TreeNode root = new TreeNode(max);
    root.left = buildTree(nums, start, maxIndex - 1);
    root.right = buildTree(nums, maxIndex + 1, end);
    return root;
  }
}
