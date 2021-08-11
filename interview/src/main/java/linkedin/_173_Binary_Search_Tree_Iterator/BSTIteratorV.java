package linkedin._173_Binary_Search_Tree_Iterator;


import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public final class BSTIteratorV implements BSTIterator {
  private final Deque<TreeNode> stack = new ArrayDeque<>();

  public BSTIteratorV(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    assert hasNext();
    final TreeNode toRemove = stack.pop();
    TreeNode cur = toRemove.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
    return toRemove.val;
  }
}
