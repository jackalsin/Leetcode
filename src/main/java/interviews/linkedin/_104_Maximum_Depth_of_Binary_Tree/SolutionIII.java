package interviews.linkedin._104_Maximum_Depth_of_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = maxDepth(root.left), right = maxDepth(root.right);
    return Math.max(left, right) + 1;
  }
}
