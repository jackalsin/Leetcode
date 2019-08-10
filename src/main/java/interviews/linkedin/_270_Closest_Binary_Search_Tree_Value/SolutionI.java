package interviews.linkedin._270_Closest_Binary_Search_Tree_Value;

import utils.TreeNode;

public final class SolutionI implements Solution {

  public int closestValue(TreeNode root, double target) {

    final TreeNode child = root.val < target ? root.right : root.left;
    if (child == null) {
      return root.val;
    }
    final int childMin = closestValue(child, target);

    return (Math.abs(root.val - target) < Math.abs(childMin - target)) ? root.val : childMin;
  }
}
