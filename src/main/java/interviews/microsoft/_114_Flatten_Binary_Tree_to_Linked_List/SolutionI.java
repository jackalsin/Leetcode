package interviews.microsoft._114_Flatten_Binary_Tree_to_Linked_List;

import utils.TreeNode;

public final class SolutionI implements Solution {

  /**
   * O (N)
   *
   * @param root
   */
  public void flatten(TreeNode root) {
    flattenHelper(root);
  }

  private TreeNode flattenHelper(TreeNode root) {
    if (root == null) {
      return null;
    }
    final TreeNode left = root.left, right = root.right;
    root.right = flattenHelper(left);
    root.left = null;
    TreeNode cur = root;
    while (cur.right != null) {
      cur = cur.right;
    }

    cur.right = flattenHelper(right);
    return root;
  }
}
