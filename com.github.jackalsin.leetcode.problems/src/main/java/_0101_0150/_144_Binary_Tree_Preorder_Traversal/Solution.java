package _0101_0150._144_Binary_Tree_Preorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();
    if (root != null) {
      stack.push(root);
      while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        if (cur != null) {
          result.add(cur.val);
          if (cur.right != null) {
            stack.push(cur.right);
          }
          if (cur.left != null) {
            stack.push(cur.left);
          }
        }
      }
    }
    return result;
  }
}
