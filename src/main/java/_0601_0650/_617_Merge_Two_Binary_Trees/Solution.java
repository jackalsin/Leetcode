package _0601_0650._617_Merge_Two_Binary_Trees;

import utils.binaryTree.TreeNode;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
public class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    } else if (t1 == null) {
      return t2;
    } else if (t2 == null) {
      return t1;
    } else {
      final TreeNode root = new TreeNode(t1.val + t2.val);
      root.left = mergeTrees(t1.left, t2.left);
      root.right = mergeTrees(t1.right, t2.right);
      return root;
    }
  }
}
