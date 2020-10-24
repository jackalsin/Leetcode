package _1001_1050._1038_Binary_Search_Tree_to_Greater_Sum_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhixi
 * @version 1.0 on 10/23/2020
 */
public final class SolutionI implements Solution {
  @Override
  public TreeNode bstToGst(final TreeNode root) {
    int sum = 0;
    final Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.right;
      } else {
        cur = stack.pop();
        sum += cur.val;
        cur.val = sum;
        cur = cur.left;
      }
    }
    return root;
  }
}
