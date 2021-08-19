package airbnb._108_Convert_Sorted_Array_to_Binary_Search_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 1/25/2019.
 */
public final class SolutionI implements Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  private static TreeNode sortedArrayToBST(final int[] nums, final int start, final int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return new TreeNode(nums[start]);
    }
    final int mid = start + (end - start) / 2;
    final TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(nums, start, mid - 1);
    root.right = sortedArrayToBST(nums, mid + 1, end);
    return root;
  }
}
