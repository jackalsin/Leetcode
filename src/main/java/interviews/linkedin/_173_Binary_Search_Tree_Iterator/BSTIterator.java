package interviews.linkedin._173_Binary_Search_Tree_Iterator;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public class BSTIterator {
  private final Deque<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new ArrayDeque<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    TreeNode curNode = stack.pop();
    int result = curNode.val;
    curNode = curNode.right;
    while (curNode != null) {
      stack.push(curNode);
      curNode = curNode.left;
    }
    return result;
  }
}
