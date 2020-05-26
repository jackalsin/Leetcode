package interviews.linkedin._173_Binary_Search_Tree_Iterator;


import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/4/2019
 */
public final class BSTIteratorIII implements BSTIterator {
  private final Deque<TreeNode> stack = new ArrayDeque<>();

  public BSTIteratorIII(TreeNode root) {
    if (root == null) {
      throw new NullPointerException();
    }
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public int next() {
    final TreeNode toRemove = stack.pop();
    TreeNode cur = toRemove.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
    return toRemove.val;
  }
}
