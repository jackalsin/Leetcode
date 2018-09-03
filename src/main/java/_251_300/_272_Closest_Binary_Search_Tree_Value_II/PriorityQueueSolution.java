package _251_300._272_Closest_Binary_Search_Tree_Value_II;

import utils.TreeNode;

import java.util.*;

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
