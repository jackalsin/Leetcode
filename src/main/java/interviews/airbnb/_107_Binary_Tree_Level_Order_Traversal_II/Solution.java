package interviews.airbnb._107_Binary_Tree_Level_Order_Traversal_II;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 1/25/2019.
 */
public class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    final LinkedList<List<Integer>> result = new LinkedList<>();
    if (root == null) {
      return result;
    }
    final Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      final int size = q.size();
      final List<Integer> curLine = new ArrayList<>();
      result.addFirst(curLine);
      for (int i = 0; i < size; i++) {
        final TreeNode toRemove = q.remove();
        curLine.add(toRemove.val);
        if (toRemove.left != null) {
          q.add(toRemove.left);
        }
        if (toRemove.right != null) {
          q.add(toRemove.right);
        }
      }
    }
    return result;
  }

}