package facebook._314_Binary_Tree_Vertical_Order_Traversal;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 5/3/2021
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) return Collections.emptyList();
    final TreeMap<Integer, List<Integer>> idToVals = new TreeMap<>();
    final Queue<Pair> q = new ArrayDeque<>() {{
      add(new Pair(root, 0));
    }};
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final var toRemove = q.remove();
        idToVals.computeIfAbsent(toRemove.index, k -> new ArrayList<>()).add(toRemove.node.val);
        if (toRemove.node.left != null) q.add(new Pair(toRemove.node.left, toRemove.index - 1));
        if (toRemove.node.right != null) q.add(new Pair(toRemove.node.right, toRemove.index + 1));
      }
    }
    final List<List<Integer>> result = new ArrayList<>();
    for (final var e : idToVals.entrySet()) {
      result.add(e.getValue());
    }
    return result;
  }

  private static final class Pair {
    private final TreeNode node;
    private final int index;

    private Pair(TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }
  }

}
