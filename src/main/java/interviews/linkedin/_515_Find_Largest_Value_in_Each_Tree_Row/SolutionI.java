package interviews.linkedin._515_Find_Largest_Value_in_Each_Tree_Row;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionI implements Solution {
  public List<Integer> largestValues(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    final Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      final int size = q.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; ++i) {
        final TreeNode toRemove = q.remove();
        max = Math.max(max, toRemove.val);
        if (toRemove.left != null) {
          q.add(toRemove.left);
        }
        if (toRemove.right != null) {
          q.add(toRemove.right);
        }
      }
      result.add(max);
    }
    return result;
  }

}
