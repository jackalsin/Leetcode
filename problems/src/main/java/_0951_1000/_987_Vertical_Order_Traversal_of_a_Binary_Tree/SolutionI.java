package _0951_1000._987_Vertical_Order_Traversal_of_a_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 10/6/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Map<Integer, List<Integer>>> coordinateToVals = new TreeMap<>();

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    verticalTraversal(root, 0, 0);
//    System.out.println(coordinateToVals);
    for (final var e1 : coordinateToVals.entrySet()) {
      final Map<Integer, List<Integer>> treeMap = e1.getValue();
      final List<Integer> curLine = new ArrayList<>();
      for (final List<Integer> cur : treeMap.values()) {
        Collections.sort(cur);
        curLine.addAll(cur);
      }
      result.add(curLine);
    }
    return result;
  }

  private void verticalTraversal(final TreeNode root, final int x, final int y) {
    if (root == null) {
      return;
    }
    coordinateToVals
        .computeIfAbsent(x, k -> new TreeMap<>((a, b) -> Integer.compare(b, a)))
        .computeIfAbsent(y, k -> new ArrayList<>())
        .add(root.val);
    verticalTraversal(root.left, x - 1, y - 1);
    verticalTraversal(root.right, x + 1, y - 1);
  }
}
