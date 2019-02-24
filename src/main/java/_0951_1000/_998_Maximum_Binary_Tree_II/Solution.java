package _0951_1000._998_Maximum_Binary_Tree_II;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 2/23/2019.
 */
public class Solution {
  public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (root.val < val) {
      final TreeNode newRoot = new TreeNode(val);
      newRoot.left = root;
      return newRoot;
    } else {
      root.right = insertIntoMaxTree(root.right, val);
      return root;
    }
  }
}
