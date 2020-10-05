package _0251_0300._272_Closest_Binary_Search_Tree_Value_II;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 9/1/2017.
 */
public final class PriorityQueueSolution implements Solution {

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    final PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Double.compare(Math.abs(target - (double) o2), Math.abs(target - (double) o1));
      }
    });

    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();

        pq.add(root.val);
        if (pq.size() > k) {
          pq.remove();
        }

        root = root.right;
      }
    }

    final LinkedList<Integer> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove());
    }
    return result;
  }

}
