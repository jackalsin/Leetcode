package _201_250._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/18/2017.
 */
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    Deque<TreeNode> stackFirst = null;
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (root == p || root == q) {
          if (stackFirst == null) {
            stackFirst = new ArrayDeque<>(stack);
            stackFirst.push(root);
          } else {
            stack.push(root);
            break;
          }
        }
        root = root.right;
      }
    }

    TreeNode result = null;
    for (int i = 0; i < Math.min(stack.size(), stackFirst.size()); ++i) {
//      if (stack.isEmpty()) {
//        return result;
//      } else if (stackFirst.isEmpty()) {
//        return result;
//      } else {
//        TreeNode node1 = stack.removeFirst();
//        if (node1 == stackFirst.removeFirst()) {
//          result = node1;
//        } else {
//          break;
//        }
//      }
      TreeNode node1 = stack.removeLast();
      if (node1 == stackFirst.removeLast()) {
        result = node1;
      } else {
        break;
      }
    }
    return result;
  }
}
