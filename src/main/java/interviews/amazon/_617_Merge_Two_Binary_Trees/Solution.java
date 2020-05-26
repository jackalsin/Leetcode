package interviews.amazon._617_Merge_Two_Binary_Trees;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
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
      TreeNode newRoot = new TreeNode(t1.val + t2.val);
      newRoot.left = mergeTrees(t1.left, t2.left);
      newRoot.right = mergeTrees(t1.right, t2.right);
      return newRoot;
    }
  }
}
