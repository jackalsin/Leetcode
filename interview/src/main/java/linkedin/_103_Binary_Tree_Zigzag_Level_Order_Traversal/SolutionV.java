package linkedin._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/8/2021
 */
public final class SolutionV implements Solution {
  @Override
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) return Collections.emptyList();
    final Queue<TreeNode> q = new ArrayDeque<>() {{
      add(root);
    }};
    final List<List<Integer>> result = new ArrayList<>();
    while (!q.isEmpty()) {
      final int size = q.size();
      final List<Integer> cur = new ArrayList<>();
      for (int i = 0; i < size; ++i) {
        final TreeNode toRemove = q.remove();
        cur.add(toRemove.val);
        if (toRemove.left != null) q.add(toRemove.left);
        if (toRemove.right != null) q.add(toRemove.right);
      }
      if (result.size() % 2 != 0) Collections.reverse(cur);
      result.add(cur);
    }
    return result;
  }
}
