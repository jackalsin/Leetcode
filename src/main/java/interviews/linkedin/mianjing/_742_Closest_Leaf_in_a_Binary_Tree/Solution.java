package interviews.linkedin.mianjing._742_Closest_Leaf_in_a_Binary_Tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

  public int findClosestLeaf(TreeNode root, int k) {
    if (root == null) {
      return 0;
    }
    final Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    int minDiff = Integer.MAX_VALUE, minCandidate = root.val; // any value is fine
    while (!q.isEmpty()) {
      final TreeNode toRemove = q.remove();
      if (toRemove.left == null && toRemove.right == null) {
        final int curDiff = Math.abs(toRemove.val - k);
        if (curDiff < minDiff) {
          minDiff = curDiff;
          minCandidate = toRemove.val;
        }
      } else {

        if (toRemove.left != null) {
          q.add(toRemove.left);
        }
        if (toRemove.right != null) {
          q.add(toRemove.right);
        }
      }
    }

    assert minDiff != Integer.MAX_VALUE;
    return minCandidate;
  }
}
