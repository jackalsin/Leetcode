package pinterest._114_Flatten_Binary_Tree_to_Linked_List;

import definition.binaryTree.TreeNode;

public class Solution {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);
    final TreeNode right = root.right;
    root.right = root.left;
    root.left = null;
    while (root.right != null) {
      root = root.right;
    }
    root.right = right;
  }
}
