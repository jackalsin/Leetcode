package interviews.linkedin._104_Maximum_Depth_of_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
