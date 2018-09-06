package interviews.linkedin._100_Same_Tree;

import utils.TreeNode;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null) {
      return q == null;
    }
    if (q == null) {
      return false;
    }
    return q.val == p.val
        && isSameTree(p.left, q.left)
        && isSameTree(p.right, q.right);
  }
}
