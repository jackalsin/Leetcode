package microsoft._102_Binary_Tree_Level_Order_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    final Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      final List<Integer> curLine = new ArrayList<>();
      final int size = q.size();
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
      result.add(curLine);
    }
    return result;
  }
}
