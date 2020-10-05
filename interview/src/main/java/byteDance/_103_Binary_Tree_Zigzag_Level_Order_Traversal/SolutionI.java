package byteDance._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    boolean shouldReverse = false;
    final Queue<TreeNode> q = new ArrayDeque<>() {{
      add(root);
    }};
    while (!q.isEmpty()) {
      final int size = q.size();
      final List<Integer> curLine = new ArrayList<>();
      for (int i = 0; i < size; ++i) {
        final TreeNode toRemove = q.remove();
        curLine.add(toRemove.val);
        if (toRemove.left != null) q.add(toRemove.left);
        if (toRemove.right != null) q.add(toRemove.right);
      }
      if (shouldReverse) {
        Collections.reverse(curLine);
      }
      shouldReverse = !shouldReverse;
      result.add(curLine);
    }
    return result;
  }
}
