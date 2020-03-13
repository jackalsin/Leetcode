package _0651_0700._700_Search_in_a_Binary_Search_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    } else if (root.val < val) {
      return searchBST(root.right, val);
    } else {
      return searchBST(root.left, val);
    }
  }
}
