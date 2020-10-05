package _1001_1050._1028_Recover_a_Tree_From_Preorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 7/28/2019
 */
public final class StackSolution implements Solution {
  @Override
  public TreeNode recoverFromPreorder(String s) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      int level = 0;
      while (s.charAt(i) == '-') {
        level++;
        i++;
      }
      int num = s.charAt(i) - '0';
      while (i + 1 < s.length() && s.charAt(i + 1) != '-') {
        num = num * 10 + s.charAt(i + 1) - '0';
        i++;
      }
      final TreeNode root = new TreeNode(num);
      while (stack.size() > level) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        if (stack.peek().left == null) {
          stack.peek().left = root;
        } else {
          stack.peek().right = root;
        }
      }
      stack.push(root);
    }
    while (stack.size() > 1) {
      stack.pop();
    }
    return stack.pop();
  }
}
