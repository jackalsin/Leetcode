package _0301_0350._314_Binary_Tree_Vertical_Order_Traversal;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/18/2017.
 */
public class Solution {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    Map<Integer, List<Integer>> colToElements = new HashMap<>();

    Deque<TreeNode> queue = new ArrayDeque<>();
    Deque<Integer> colQueue = new ArrayDeque<>();
    int maxCol = 0, minCol = 0;
    queue.addLast(root);
    colQueue.addLast(0);
    while (!queue.isEmpty()) {
      final int size = queue.size();
      for (int i = 0; i < size; ++i) {
        TreeNode curNode = queue.removeFirst();
        int curCol = colQueue.removeFirst();
        colToElements.putIfAbsent(curCol, new ArrayList<>());
        colToElements.get(curCol).add(curNode.val);
        if (curNode.left != null) {
          queue.addLast(curNode.left);
          colQueue.addLast(curCol - 1);
          minCol = Math.min(minCol, curCol - 1);
        }

        if (curNode.right != null) {
          queue.addLast(curNode.right);
          colQueue.addLast(curCol + 1);
          maxCol = Math.max(maxCol, curCol + 1);
        }
      }
    }

    List<List<Integer>> result = new ArrayList<>();
    for (int i = minCol; i <= maxCol; i++) {
      result.add(colToElements.getOrDefault(i, new ArrayList<>()));
    }
    return result;
  }
}
