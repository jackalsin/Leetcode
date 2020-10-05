package microsoft._270_Closest_Binary_Search_Tree_Value;

import definition.binaryTree.TreeNode;

public class Solution {

  public int closestValue(TreeNode root, double target) {

    assert root != null;
    final TreeNode child = root.val > target ? root.left : root.right;
    if (child == null) {
      return root.val;
    }
    final int candidate = closestValue(child, target);

    return Math.abs(target - candidate) > Math.abs(target - root.val) ?
        root.val : candidate;
  }

}
