package microsoft._654_Maximum_Binary_Tree;

import definition.binaryTree.TreeNode;

public final class SolutionII implements Solution { // TODO:

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructMaximumBinaryTree(nums, 0, nums.length - 1);
  }

  /**
   * @param nums
   * @param start inclusive
   * @param end   inclusive
   * @return
   */
  private static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return new TreeNode(nums[start]);
    }
    int maxIndex = getMax(nums, start, end);
    final TreeNode root = new TreeNode(nums[maxIndex]);
    root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
    root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
    return root;
  }

  private static int getMax(int[] nums, int start, int end) {
    int res = start;
    for (int i = start; i <= end; i++) {
      if (nums[res] < nums[i]) {
        res = i;
      }
    }
    return res;
  }
}
