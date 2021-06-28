package _1051_1100._1080_Insufficient_Nodes_in_Root_to_Leaf_Paths;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/27/2021
 */
public final class SolutionI implements Solution {
  @Override
  public TreeNode sufficientSubset(TreeNode root, int limit) {
    if (root == null) return null;
    if (root.left == null && root.right == null) {
      if (root.val < limit) {
        return null;
      } else {
        return root;
      }
    }
    root.left = sufficientSubset(root.left, limit - root.val);
    root.right = sufficientSubset(root.right, limit - root.val);
    if (root.left == null && root.right == null) {
      // this means both children are removed
      return null;
    }
    return root;
  }
}
