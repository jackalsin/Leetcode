package _0951_1000._971_Flip_Binary_Tree_To_Match_Preorder_Traversal;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhixi
 * @version 1.0 on 10/3/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Integer> valToIndex = new HashMap<>();
  private final List<Integer> result = new ArrayList<>();
  private static final List<Integer> UNREACH = List.of(-1);

  public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
    assert root != null;
    final int n = voyage.length;
    for (int i = 0; i < n; ++i) {
      valToIndex.put(voyage[i], i);
    }

    final boolean reached = flipMatchVoyage(root, voyage, 0, n - 1);
    return reached ? result : UNREACH;
  }

  private boolean flipMatchVoyage(final TreeNode root, final int[] voyage, final int left, final int right) {
    assert root != null;
    if (root.val != voyage[left]) {
      return false;
    }
    if (root.left == null && root.right == null) {
      if (left != right) {
        return false;
      }
      return true;
    } else if (root.left == null) {
      return flipMatchVoyage(root.right, voyage, left + 1, right);
    } else if (root.right == null) {
      return flipMatchVoyage(root.left, voyage, left + 1, right);
    } else {
      if (root.left.val == voyage[left + 1]) {
        final int rightIndex = valToIndex.get(root.right.val);
        return flipMatchVoyage(root.left, voyage, left + 1, rightIndex - 1) &&
            flipMatchVoyage(root.right, voyage, rightIndex, right);
      } else if (root.right.val == voyage[left + 1]) {
        result.add(root.val);
        final int leftIndex = valToIndex.get(root.left.val);
        return flipMatchVoyage(root.left, voyage, leftIndex, right) &&
            flipMatchVoyage(root.right, voyage, left + 1, leftIndex - 1);
      } else {
        return false;
      }
    }
  }

}
