package _0101_0150._145_Binary_Tree_Postorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || root != null) {
      if (root != null) {
        stack.push(root);
        result.addFirst(root.val);
        root = root.right;
      } else {
        root = stack.pop();
        root = root.left;
      }
    }
    return result;
  }
}
