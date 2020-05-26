package interviews.pinterest._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    boolean isReverse = false;
    final Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      final List<Integer> curLine = new ArrayList<>();
      result.add(curLine);
      final int size = queue.size();
      for (int i = 0; i < size; i++) {
        final TreeNode toRemove = queue.remove();
        curLine.add(toRemove.val);
        if (toRemove.left != null) {
          queue.add(toRemove.left);
        }
        if (toRemove.right != null) {
          queue.add(toRemove.right);
        }
      }

      if (isReverse) {
        Collections.reverse(curLine);
      }
      isReverse = !isReverse;

    }
    return result;
  }
}
