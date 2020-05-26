package _0651_0700._654_Maximum_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/31/2017.
 */
public final class ONSolution implements Solution {

  /**
   * Time Complexity: o(N)
   *
   * @param nums
   * @return
   */
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    final Deque<TreeNode> stack = new ArrayDeque<>();

    for (int num : nums) {
      final TreeNode curNode = new TreeNode(num);
      while (!stack.isEmpty() && stack.peek().val < num) {
        curNode.left = stack.pop();
      }
      if (!stack.isEmpty()) {
        stack.peek().right = curNode;
      }
      stack.push(curNode);
    }

    return stack.isEmpty() ? null : stack.removeLast();
  }

}
