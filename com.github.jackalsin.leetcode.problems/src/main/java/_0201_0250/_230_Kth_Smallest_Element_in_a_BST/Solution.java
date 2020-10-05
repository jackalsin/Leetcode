package _0201_0250._230_Kth_Smallest_Element_in_a_BST;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
public class Solution {

  public int kthSmallest(TreeNode root, int k) {
//    return pqSolution(root, k);
    return binarySearch(root, k);
  }

  private int binarySearch(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.addLast(cur);
        cur = cur.left;
      } else {
        cur = stack.removeLast();
        if (k == 1) {
          return cur.val;
        } else {
          k--;
        }
        cur = cur.right;
      }
    }

    throw new IllegalArgumentException("k is not valid");
  }

  /**
   * 11 ms
   * @param root
   * @param k
   * @return
   */
  private int pqSolution(TreeNode root, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      final int size = queue.size();
      for (int i = 0; i < size; ++i) {
        TreeNode curNode = queue.removeFirst();
        if (curNode.left != null) queue.addLast(curNode.left);
        if (curNode.right != null) queue.addLast(curNode.right);
        int cur = curNode.val;
        if (pq.size() == k) {
          if (pq.peek() > cur) {
            pq.poll();
            pq.add(cur);
          }
        } else {
          pq.add(cur);
        }
      }
    }
    return pq.peek();
  }
}
