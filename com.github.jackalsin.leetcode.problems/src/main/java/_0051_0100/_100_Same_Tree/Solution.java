package _0051_0100._100_Same_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/6/2017.
 */
public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return p == null && q == null || !(p == null || q == null) && isSameTree(p.left, q.left) &&
        (p.val == q.val) && isSameTree(p.right, q.right);

  }
}
