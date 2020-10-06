package _0951_1000._968_Binary_Tree_Cameras;

import utils.binaryTree.TreeNode;

/**
 * @author zhixi
 * @version 1.0 on 10/3/2020
 */
public final class SolutionI implements Solution {
  private static final int NOT_COVERED = 1, CAMERA = 2, COVERED = 3;
  private int res = 0;

  public int minCameraCover(TreeNode root) {
    final int rootStatus = dfs(root);
    return (rootStatus == NOT_COVERED ? 1 : 0) + res;
  }

  private int dfs(final TreeNode root) {
    if (root == null) {
      return COVERED;
    }
    if (root.left == null && root.right == null) { // a leaf
      return NOT_COVERED;
    }
    final int left = dfs(root.left), right = dfs(root.right);
    if (left == NOT_COVERED || right == NOT_COVERED) {
      res++;
      return CAMERA;
    }
    if (left == CAMERA || right == CAMERA) {
      return COVERED;
    }
    return NOT_COVERED;
  }
}
