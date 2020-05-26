package interviews.linkedin._173_Binary_Search_Tree_Iterator;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/29/2019
 */
public final class BSTIteratorIV implements BSTIterator {
  private final Deque<TreeNode> stack = new ArrayDeque<>();

  public BSTIteratorIV(final TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode cur = root;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    assert !stack.isEmpty();
    final TreeNode result = stack.pop();
    TreeNode cur = result.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
    return result.val;
  }
}
