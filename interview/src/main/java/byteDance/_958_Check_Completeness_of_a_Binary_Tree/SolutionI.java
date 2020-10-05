package byteDance._958_Check_Completeness_of_a_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return true;
    }
    final Queue<TreeNode> q = new LinkedList<>() {{
      add(root);
    }};
    boolean hasNull = false;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final TreeNode toRemove = q.remove();
        if (toRemove == null) {
          hasNull = true;
        } else {
          if (hasNull) return false;
          q.add(toRemove.left);
          q.add(toRemove.right);
        }
      }
    }
    return true;
  }
}
