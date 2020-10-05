package _0751_0800._776_Split_BST;

import utils.binaryTree.TreeNode;

public class Solution {
  public TreeNode[] splitBST(TreeNode root, int V) {
    final TreeNode[] res = new TreeNode[2];
    if (root == null) {
      return res;
    }
    if (root.val > V) {
      res[1] = root;
      final TreeNode[] prev = splitBST(root.left, V);
      root.left = prev[1];
      res[0] = prev[0];
    } else {
      res[0] = root;
      final TreeNode[] prev = splitBST(root.right, V);
      root.right = prev[0];
      res[1] = prev[0];
    }

    return res;
  }
}
