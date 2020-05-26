package _0101_0150._108_Convert_Sorted_Array_to_Binary_Search_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/16/2017.
 */
public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
    if (start > end) return null;
    int mid = (end - start + 1) / 2 + start;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(nums, start, mid - 1);
    root.right = sortedArrayToBST(nums, mid + 1, end);
    return root;
  }
}
