package byteDance._173_Binary_Search_Tree_Iterator;


import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/1/2021
 */
public final class BSTIteratorI implements BSTIterator {
  private final Deque<TreeNode> stack = new ArrayDeque<>();

  public BSTIteratorI(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  public int next() {
    final TreeNode toRemove = stack.pop();
    final int res = toRemove.val;
    TreeNode cur = toRemove.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
    return res;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }
}
