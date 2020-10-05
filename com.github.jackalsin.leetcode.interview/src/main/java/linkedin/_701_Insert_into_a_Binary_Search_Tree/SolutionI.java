package linkedin._701_Insert_into_a_Binary_Search_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class SolutionI implements Solution {
  @Override
  public TreeNode insertIntoBST(final TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    TreeNode cur = root;
    while (cur != null) {
      if (cur.val > val) {
        if (cur.left == null) {
          cur.left = new TreeNode(val);
          break;
        } else {
          cur = cur.left;
        }
      } else {
        assert cur.val < val;
        if (cur.right == null) {
          cur.right = new TreeNode(val);
          break;
        } else {
          cur = cur.right;
        }
      }
    }
    return root;
  }
}
