package uber._104_Maximum_Depth_of_Binary_Tree;

import definition.binaryTree.TreeNode;

public class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
