package _0951_1000._951_Flip_Equivalent_Binary_Trees;

import definition.binaryTree.TreeNode;

public class Solution {
  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    } else if (root1 == null || root2 == null || root1.val != root2.val) {
      return false;
    }
    return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
        (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
  }
}
