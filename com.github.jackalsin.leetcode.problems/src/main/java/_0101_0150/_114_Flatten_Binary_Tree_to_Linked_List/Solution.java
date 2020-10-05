package _0101_0150._114_Flatten_Binary_Tree_to_Linked_List;

import definition.binaryTree.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/23/2017.
 */
public class Solution {
  /**
   * Flatten a binary tree by moving to the right sub tree
   * Still O(n), no nodes will be visited twice.
   * @param root
   */
  public void flatten(TreeNode root) {
    if (root == null) return;
    TreeNode left = root.left;
    TreeNode right = root.right;
    flatten(left);
    flatten(right);
    root.right = left;
    root.left = null;
    TreeNode curNode = root;
    // find the last node
    while (curNode.right != null) {
      curNode = curNode.right;
    }
    curNode.right = right;
  }
}
