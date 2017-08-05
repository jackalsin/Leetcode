package _151_200._199_Binary_Tree_Right_Side_View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/4/2017.
 */
public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for(int i = 0; i < size - 1; i++) {
        TreeNode curNode = queue.removeFirst();
        addChildren(curNode, queue);
      }
      TreeNode mostRight = queue.removeFirst();
      result.add(mostRight.val);
      addChildren(mostRight, queue);
    }
    return result;
  }

  private static void addChildren(TreeNode curNode, Deque<TreeNode> queue) {
    if (curNode.left != null) queue.addLast(curNode.left);
    if (curNode.right != null) queue.addLast(curNode.right);
  }
}
