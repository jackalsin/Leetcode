package interviews.byteDance._222_Count_Complete_Tree_Nodes;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class SolutionI implements Solution {

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int leftHeight = getHeight(root.left), rightHeight = getHeight(root.right);
    if (leftHeight == rightHeight) { // dies at right
      return (1 << (leftHeight)) + countNodes(root.right);
    } else {
      assert leftHeight == rightHeight + 1;
      return countNodes(root.left) + (1 << (rightHeight));
    }
  }

  private static int getHeight(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + getHeight(root.left);
  }
}
