package _151_200._173_Binary_Search_Tree_Iterator;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/31/2017.
 */
public class BSTIterator {

  private final TreeNode root;
  private Deque<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    this.root = root;
    stack = new ArrayDeque<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode resultNode = stack.pop();
    pushAll(resultNode.right);
    return resultNode.val;
  }

  private void pushAll(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

}
