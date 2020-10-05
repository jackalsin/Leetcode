package _0201_0250._222_Count_Complete_Tree_Nodes;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int leftHeight = getHeight(root.left), rightHeight = getHeight(root.right);
    if (leftHeight == rightHeight) { // last level ends in the right
      return 1 + ((1 << leftHeight) - 1) + countNodes(root.right);
    } else {
      return 1 + ((1 << rightHeight) - 1) + countNodes(root.left);
    }
  }

  private static int getHeight(final TreeNode root) {
    return root == null ? 0 : 1 + getHeight(root.left);
  }
}
