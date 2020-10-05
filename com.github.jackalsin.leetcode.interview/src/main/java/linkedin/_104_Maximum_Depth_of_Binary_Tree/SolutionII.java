package linkedin._104_Maximum_Depth_of_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/20/2017.
 */
public final class SolutionII implements Solution {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

}
