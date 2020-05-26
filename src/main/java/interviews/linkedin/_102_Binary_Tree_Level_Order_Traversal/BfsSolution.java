package interviews.linkedin._102_Binary_Tree_Level_Order_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
public final class BfsSolution implements Solution {
  @Override
  public List<List<Integer>> levelOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    final Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      final int size = q.size();
      final List<Integer> curLine = new ArrayList<>();
      result.add(curLine);
      for (int i = 0; i < size; i++) {
        final TreeNode toRemove = q.remove();
        curLine.add(toRemove.val);
        if (toRemove.left != null) {
          q.add(toRemove.left);
        }
        if (toRemove.right != null) {
          q.add(toRemove.right);
        }
      }
    }
    return result;
  }
}
