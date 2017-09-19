package _301_350._315_Count_of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/19/2017.
 */
public class Solution {

  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) return new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    TreeNode root = new TreeNode(nums[nums.length - 1]);
    result.add(0);
    for (int i = nums.length - 2; i >= 0; --i) {
      TreeNode cur = new TreeNode(nums[i]);
      buildTree(result, root, cur);
    }
    Collections.reverse(result);
    return result;
  }

  private TreeNode buildTree(List<Integer> result, TreeNode root, TreeNode cur) {
    if (root == null) {
      result.add(cur.leftChildCount);
      return cur;
    } else if (cur.val == root.val) {
      root.dup++;
      result.add(root.leftChildCount);
      return root;
    } else if (cur.val < root.val) { // go left
      root.leftChildCount++;
      root.left = buildTree(result, root.left, cur);
      return root;
    } else {
      cur.leftChildCount = root.leftChildCount + root.dup;
      root.right = buildTree(result, root.right, cur);
      return root;
    }
  }

  private static final class TreeNode {
    private TreeNode left, right;
    private final int val;
    int leftChildCount = 0;
    int dup = 1;

    TreeNode(int val) {
      this.val = val;
    }
  }
}
