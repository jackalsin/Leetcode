package _0701_0750._742_Closest_Leaf_in_a_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/19/2020
 */
public final class SolutionI implements Solution {
  private final Map<TreeNode, TreeNode> parents = new HashMap<>();
  private TreeNode target;

  public int findClosestLeaf(TreeNode root, int k) {
    traverse(root, k);
    final Queue<TreeNode> q = new ArrayDeque<>() {{
      add(target);
    }};
    final Set<TreeNode> visited = new HashSet<>() {{
      add(target);
    }};

    while (!q.isEmpty()) {
      final TreeNode toRemove = q.remove();
      if (toRemove.left == null && toRemove.right == null) {
        return toRemove.val;
      }
      if (toRemove.left != null && !visited.contains(toRemove.left)) {
        q.add(toRemove.left);
        visited.add(toRemove.left);
      }
      if (toRemove.right != null && !visited.contains(toRemove.right)) {
        q.add(toRemove.right);
        visited.add(toRemove.right);
      }
      final TreeNode parent = parents.get(toRemove);
      if (parent != null && !visited.contains(parent)) {
        q.add(parent);
        visited.add(parent);
      }
    }
    throw new IllegalStateException("Cannot find leaf. Shouldn't happen.");
  }

  private void traverse(final TreeNode root, final int k) {
    if (root == null) return;
    if (root.val == k) {
      target = root;
    }
    if (root.left != null) {
      parents.put(root.left, root);
      traverse(root.left, k);
    }
    if (root.right != null) {
      parents.put(root.right, root);
      traverse(root.right, k);
    }
  }
}
