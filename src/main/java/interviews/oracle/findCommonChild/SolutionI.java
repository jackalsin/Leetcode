package interviews.oracle.findCommonChild;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> getCommonChild(final TreeNode rootA, final TreeNode rootB) {
    if (rootA == null || rootB == null) {
      return new ArrayList<>();
    }
    final Set<Integer> result = new HashSet<>(),
        visited = new HashSet<>();
    final Queue<TreeNode> q = new ArrayDeque<>();
    q.add(rootA);
    while (!q.isEmpty()) {
      final TreeNode toRemove = q.remove();
      visited.add(toRemove.val);
      if (toRemove.left != null && !visited.contains(toRemove.left.val)) {
        visited.add(toRemove.left.val);
        q.add(toRemove.left);
      }
      if (toRemove.right != null && !visited.contains(toRemove.right.val)) {
        visited.add(toRemove.right.val);
        q.add(toRemove.right);
      }
    }

    q.add(rootB);
    while (!q.isEmpty()) {
      final TreeNode toRemove = q.remove();
      result.add(toRemove.val);
      if (toRemove.left != null) {
        q.add(toRemove.left);
      }
      if (toRemove.right != null) {
        q.add(toRemove.right);
      }
    }

    return new ArrayList<>(result);
  }

  @Override
  public int getMostRecentCommonChild(TreeNode rootA, TreeNode rootB) {
    final Set<Integer> visitedA = new HashSet<>(),
        visitedB = new HashSet<>();
    final Queue<TreeNode> q1 = new ArrayDeque<>(),
        q2 = new ArrayDeque<>();
    q1.add(rootA);
    q2.add(rootB);
    while (!q1.isEmpty() || !q2.isEmpty()) {
      if (!q1.isEmpty()) {
        final TreeNode toRemove = q1.remove();
        if (visitedB.contains(toRemove.val)) {
          return toRemove.val;
        }
        visitedA.add(toRemove.val);
        if (toRemove.left != null) {
          q1.add(toRemove.left);
        }
        if (toRemove.right != null) {
          q1.add(toRemove.right);
        }
      }

      if (!q2.isEmpty()) {
        final TreeNode toRemove = q2.remove();
        if (visitedA.contains(toRemove.val)) {
          return toRemove.val;
        }
        visitedB.add(toRemove.val);
        if (toRemove.left != null) {
          q2.add(toRemove.left);
        }
        if (toRemove.right != null) {
          q2.add(toRemove.right);
        }
      }
    }
    return -1;
  }
}
