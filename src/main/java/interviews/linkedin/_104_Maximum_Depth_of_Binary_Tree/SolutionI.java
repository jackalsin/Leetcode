package interviews.linkedin._104_Maximum_Depth_of_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/20/2017.
 */
public final class SolutionI implements Solution {
  public int maxDepth(TreeNode root) {
    int maxDepth = 0, depth = 0;
    return maxDepthHelper(root);
  }

  private int maxDepthHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepthHelper(root.left), maxDepthHelper(root.right)) + 1;
  }
}
