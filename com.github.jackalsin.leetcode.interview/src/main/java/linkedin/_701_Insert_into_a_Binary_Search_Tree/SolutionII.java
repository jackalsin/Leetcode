package linkedin._701_Insert_into_a_Binary_Search_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 9/14/2019
 */
public final class SolutionII implements Solution {
  @Override
  public TreeNode insertIntoBST(final TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    TreeNode cur = root;
    while (true) {
      assert cur.val != val;
      if (cur.val < val) {
        if (cur.right == null) {
          cur.right = new TreeNode(val);
          break;
        }
        cur = cur.right;
      } else {
        if (cur.left == null) {
          cur.left = new TreeNode(val);
          break;
        }
        cur = cur.left;
      }
    }
    return root;
  }
}
