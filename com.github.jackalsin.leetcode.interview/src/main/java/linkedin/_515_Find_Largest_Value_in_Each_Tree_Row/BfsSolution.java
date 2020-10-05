package linkedin._515_Find_Largest_Value_in_Each_Tree_Row;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/9/2019
 */
public final class BfsSolution implements Solution {

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
        final TreeNode cur = q.remove();
        max = Math.max(cur.val, max);
        if (cur.left != null) {
          q.add(cur.left);
        }
        if (cur.right != null) {
          q.add(cur.right);
        }
      } // end of for loop
      result.add(max);
    }
    return result;
  }
}
