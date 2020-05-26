package interviews.linkedin._173_Binary_Search_Tree_Iterator;

import utils.binaryTree.TreeNode;

import java.util.Stack;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class BSTIteratorII implements BSTIterator {
  private final Stack<TreeNode> stack = new Stack<>();

  public BSTIteratorII(TreeNode root) {
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
    final TreeNode resultNode = stack.pop();
    TreeNode curNode = resultNode.right;
    while (curNode != null) {
      stack.push(curNode);
      curNode = curNode.left;
    }

    return resultNode.val;
  }
}
