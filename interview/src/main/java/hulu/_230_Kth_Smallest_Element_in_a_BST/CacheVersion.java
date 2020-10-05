package hulu._230_Kth_Smallest_Element_in_a_BST;

import definition.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public final class CacheVersion implements Solution {
  private final Map<TreeNode, Integer> cache = new HashMap<>();

  public int kthSmallest(TreeNode root, int k) {
    if (root == null) {
      return 0;
    }
    final int leftDepth = getCounts(root.left);
    if (leftDepth + 1 == k) {
      return root.val;
    } else if (leftDepth + 1 < k) {
      return kthSmallest(root.right, k - leftDepth - 1);
    } else {
      return kthSmallest(root.left, k);
    }
  }

  private int getCounts(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (cache.containsKey(root)) return cache.get(root);
    final int left = getCounts(root.left),
        right = getCounts(root.right);
    final int count = left + 1 + right;
    cache.put(root, count);
    return count;
  }
}
