package _0501_0550._538_Convert_BST_to_Greater_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 1/27/2020
 */
public final class SolutionI implements Solution {
  @Override
  public TreeNode convertBST(final TreeNode root) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    // reverse inorder
    int sum = 0;
    while (!stack.isEmpty() || cur != null) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.right;
      } else {
        cur = stack.pop();
        final int curVal = cur.val;
        cur.val += sum;
        sum += curVal;
        cur = cur.left;
      }
    }

    return root;
  }

}
