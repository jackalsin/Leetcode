package byteDance._104_Maximum_Depth_of_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = maxDepth(root.left),
        right = maxDepth((root.right));
    return 1 + Math.max(left, right);
  }
}
