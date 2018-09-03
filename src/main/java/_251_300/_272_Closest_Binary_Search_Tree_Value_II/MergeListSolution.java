package _251_300._272_Closest_Binary_Search_Tree_Value_II;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/1/2017.
 */
public final class MergeListSolution implements Solution {

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    final Deque<Integer> preStack = new ArrayDeque<>(), successorQueue = new ArrayDeque<>();
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (root.val < target) {
          preStack.push(root.val);
        } else {
          successorQueue.add(root.val);
        }
        root = root.right;
      }
    } // end of while loop

    final LinkedList<Integer> result = new LinkedList<>();
    while (k-- > 0 && (!preStack.isEmpty() || !successorQueue.isEmpty())) {
      if (!preStack.isEmpty() && !successorQueue.isEmpty()) {
        if (Math.abs(preStack.peek() - target) < Math.abs(successorQueue.peek() - target)) {
          result.add(preStack.pop());
        } else {
          result.add(successorQueue.remove());
        }
      } else if (!preStack.isEmpty()) {
        result.add(preStack.pop());
      } else if (!successorQueue.isEmpty()) {
        result.add(successorQueue.remove());
      }
    }
    return result;
  }
}
