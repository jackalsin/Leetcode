package airbnb._108_Convert_Sorted_Array_to_Binary_Search_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author zhixi
 * @version 1.0 on 8/18/2021
 */
public final class SolutionII implements Solution {
  @Override
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  private static TreeNode sortedArrayToBST(final int[] nums, final int left, final int right) {
    if (left > right) return null;
    final int mid = left + (right - left) / 2;
    final TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(nums, left, mid - 1);
    root.right = sortedArrayToBST(nums, mid + 1, right);
    return root;
  }
}
