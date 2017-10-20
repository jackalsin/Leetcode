package interviews.linkedin._102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/19/2017.
 */
public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      final int size = queue.size();
      List<Integer> curLine = new ArrayList<>();
      result.add(curLine);
      for (int i = 0; i < size; ++i) {
        final TreeNode curNode = queue.poll();
        curLine.add(curNode.val);
        if (curNode.left != null) {
          queue.add(curNode.left);
        }
        if (curNode.right != null) {
          queue.add(curNode.right);
        }
      }
    }
    return result;
  }
}
