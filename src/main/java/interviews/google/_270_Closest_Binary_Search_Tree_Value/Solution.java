package interviews.google._270_Closest_Binary_Search_Tree_Value;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 1/23/2018.
 */
public class Solution {
  public int closestValue(TreeNode root, double target) {
    int curVal = root.val;
    TreeNode next = root.val > target ? root.left : root.right;
    if (next == null) {
      return root.val;
    }
    int b = closestValue(next, target);
    return Math.abs(curVal - target) > Math.abs(target - b) ? b : curVal;
  }
}
