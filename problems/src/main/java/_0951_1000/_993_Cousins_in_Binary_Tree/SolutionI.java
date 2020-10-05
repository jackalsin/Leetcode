package _0951_1000._993_Cousins_in_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  private final int[] res = {-1, -1, -1, -1};

  public boolean isCousins(TreeNode root, int x, int y) {
    isCousinsHelper(root, -1, x, y, 0);
//    System.out.println(Arrays.toString(res));
    return res[0] == res[2] && res[1] != res[3];
  }

  private void isCousinsHelper(final TreeNode root, final int parent, final int x, final int y, final int depth) {
    if (root == null) {
      return;
    }
    if (root.val == x) {
      res[0] = depth;
      res[1] = parent;
    }
    if (root.val == y) {
      res[2] = depth;
      res[3] = parent;
    }
    isCousinsHelper(root.left, root.val, x, y, depth + 1);
    isCousinsHelper(root.right, root.val, x, y, depth + 1);
  }

}
