package _0201_0250._250_Count_Univalue_Subtrees;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/23/2017.
 */
public class Solution {
  private int count = 0;

  public int countUnivalSubtrees(TreeNode root) {
    isUnivalSubtreesAndCount(root);
    return count;
  }

  private boolean isUnivalSubtreesAndCount(TreeNode root) {
    if (root == null) {
      return true;
    } else {
      boolean left = isUnivalSubtreesAndCount(root.left);
      boolean right = isUnivalSubtreesAndCount(root.right);
      if (left && right) {
        if (root.left != null && root.val != root.left.val) return false;
        if (root.right != null && root.val != root.right.val) return false;
        count++;
        return true;
      }
      return false;
    }
  }

}
