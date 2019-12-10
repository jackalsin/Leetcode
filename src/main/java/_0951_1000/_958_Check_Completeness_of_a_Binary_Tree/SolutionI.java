package _0951_1000._958_Check_Completeness_of_a_Binary_Tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 12/9/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    final Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    boolean hasNull = false;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final TreeNode toRemove = q.remove();
        if (toRemove != null) {
          if (hasNull) return false;
          q.add(toRemove.left);
          q.add(toRemove.right);
        } else {
          hasNull = true;
        }
      }
    }
    return true;
  }
}
