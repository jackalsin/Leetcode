package microsoft._114_Flatten_Binary_Tree_to_Linked_List;

import definition.binaryTree.TreeNode;

public final class OnePassSolution implements Solution {

  private TreeNode prev;

  /**
   * TODO: write a blog
   * Post order traverse
   *
   * @param root
   */
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
  }

}
