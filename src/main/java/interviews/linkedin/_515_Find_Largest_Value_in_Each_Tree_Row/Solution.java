package interviews.linkedin._515_Find_Largest_Value_in_Each_Tree_Row;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public class Solution {
  public List<Integer> largestValues(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      final int size = queue.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode curNode = queue.poll();
        max = Math.max(curNode.val, max);
        if (curNode.left != null) {
          queue.add(curNode.left);
        }
        if (curNode.right != null) {
          queue.add(curNode.right);
        }
      }
      result.add(max);
    }
    return result;
  }

}
