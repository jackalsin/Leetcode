package linkedin._100_Same_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/8/2021
 */
public final class SolutionIV implements Solution {
  @Override
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == q) return true;
    if (p == null) return false;
    if (q == null) return false;
    return p.val == q.val && isSameTree(p.left, q.left)
        && isSameTree(p.right, q.right);
  }
}
