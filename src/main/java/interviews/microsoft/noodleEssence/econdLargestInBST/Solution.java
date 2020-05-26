package interviews.microsoft.noodleEssence.econdLargestInBST;

import utils.binaryTree.TreeNode;

public class Solution {

  /**
   * @param root
   * @return
   */
  public int getSecondLargest(final TreeNode root) {
    if (root == null) {
      throw new NullPointerException();
    }
    TreeNode max = root, prev = null;
    while (max.right != null) {
      prev = max;
      max = max.right;
    }

    if (max.left != null) { // find max in max.left
      TreeNode cur = max.left;
      while (cur.right != null) {
        cur = cur.right;
      }
      return cur.val;
    } else if (prev == null) {
      throw new IllegalStateException("Not second larges");
    } else {
      return prev.val;
    }
  }
}
