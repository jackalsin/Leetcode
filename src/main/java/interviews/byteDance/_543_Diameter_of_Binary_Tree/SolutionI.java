package interviews.byteDance._543_Diameter_of_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  private int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    path(root);
    return max;
  }

  private int path(final TreeNode root) {
    if (root == null) {
      return -1;
    }
    int leftLen = path(root.left),
        rightLen = path(root.right);
    final int res = Math.max(leftLen, rightLen) + 1;
    max = Math.max(max, leftLen + rightLen + 2);
    return res;
  }
}
