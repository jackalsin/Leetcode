package interviews.linkedin.mianjing._742_Closest_Leaf_in_a_Binary_Tree;

import utils.TreeNode;

import java.util.*;

public class Solution {

  public int findClosestLeaf(TreeNode root, int k) {
    final Map<TreeNode, TreeNode> parents = new HashMap<>();
    final Set<TreeNode> visited = new HashSet<>();
    TreeNode kNode = dfs(parents, root, k);
    final Queue<TreeNode> q = new ArrayDeque<>();
    q.add(kNode);
    visited.add(kNode);
    while (!q.isEmpty()) {
      final TreeNode toRemove = q.remove();
      if (toRemove.left == null && toRemove.right == null) {
        return toRemove.val;
      }
      if (toRemove.left != null && !visited.contains(toRemove.left)) {
        visited.add(toRemove.left);
        q.add(toRemove.left);
      }
      if (toRemove.right != null && !visited.contains(toRemove.right)) {
        q.add(toRemove.right);
        visited.add(toRemove.right);
      }

      if (parents.containsKey(toRemove)) {
        final TreeNode parent = parents.get(toRemove);
        q.add(parent);
        visited.add(parent);
      }

    }
    throw new IllegalStateException();
  }

  private static TreeNode dfs(Map<TreeNode, TreeNode> parents, TreeNode root, int k) {
    if (root == null) {
      return null;
    }
    if (root.left != null) {
      parents.put(root.left, root);
    }
    if (root.right != null) {
      parents.put(root.right, root);
    }
    final TreeNode left = dfs(parents, root.left, k), right = dfs(parents, root.right, k);
    if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }
    return root.val == k ? root : null;
  }
}
