package interviews.linkedin._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    final Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    boolean shouldReverse = false;
    while (!q.isEmpty()) {
      final List<Integer> curLine = new ArrayList<>();
      result.add(curLine);
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final TreeNode toRemove = q.remove();
        curLine.add(toRemove.val);
        if (toRemove.left != null) {
          q.add(toRemove.left);
        }
        if (toRemove.right != null) {
          q.add(toRemove.right);
        }
      }
      if (shouldReverse) {
        Collections.reverse(curLine);
      }
      shouldReverse = !shouldReverse;
    }
    return result;
  }
}
