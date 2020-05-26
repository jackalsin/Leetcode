package interviews.google._272_Closest_Binary_Search_Tree_Value_II;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    final List<Integer> result = new ArrayList<>();
    final Deque<TreeNode> predecessors = getPredecessor(root, target),
        successors = getSuccessors(root, target);

    if (!predecessors.isEmpty()
        && !successors.isEmpty()
        && predecessors.peekLast() == successors.peekLast()) {
      nextSuccessor(successors);
    }
    while (k-- > 0) {
      if (predecessors.isEmpty()) {
        result.add(nextSuccessor(successors));
      } else if (successors.isEmpty()) {
        result.add(nextPredecessor(predecessors));
      } else {
        final int prev = predecessors.peekLast().val, succ = successors.peekLast().val;
        if (target - prev > succ - target) {
          result.add(nextSuccessor(successors));
        } else {
          result.add(nextPredecessor(predecessors));
        }
      }
    }
    return result;
  }

  private int nextPredecessor(Deque<TreeNode> predecessors) {
    TreeNode curNode = predecessors.removeLast();
    final int result = curNode.val;
    curNode = curNode.left;
    while (curNode != null) {
      predecessors.addLast(curNode);
      curNode = curNode.right;
    }
    return result;
  }

  private int nextSuccessor(final Deque<TreeNode> successors) {
    TreeNode curNode = successors.removeLast();
    final int result = curNode.val;
    curNode = curNode.right;
    while (curNode != null) {
      successors.addLast(curNode);
      curNode = curNode.left;
    }
    return result;
  }

  private Deque<TreeNode> getSuccessors(TreeNode root, double target) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curNode = root;
    while (curNode != null) {
      if (curNode.val == target) {
        stack.addLast(curNode);
        break;
      } else if (curNode.val > target) {
        stack.addLast(curNode);
        curNode = curNode.left;
      } else {
        curNode = curNode.right;
      }
    }
    return stack;
  }

  private Deque<TreeNode> getPredecessor(TreeNode root, double target) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curNode = root;
    while (curNode != null) {
      if (curNode.val == target) {
        stack.addLast(curNode);
        break;
      } else if (curNode.val < target) {
        stack.addLast(curNode);
        curNode = curNode.right;
      } else {
        curNode = curNode.left;
      }
    }
    return stack;
  }
}
