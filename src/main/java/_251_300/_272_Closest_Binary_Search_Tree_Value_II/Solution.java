package _251_300._272_Closest_Binary_Search_Tree_Value_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 9/1/2017.
 */
public class Solution {
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
//    return oNSolution(root, target, k);
    return oLogNSolution(root, target, k);
  }

  private List<Integer> oLogNSolution(TreeNode root, double target, int k) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> predecessors = getPredecessor(root, target);
    Deque<TreeNode> successors = getSuccessors(root, target);
    if (!predecessors.isEmpty() && !successors.isEmpty()
        && predecessors.peekLast() == successors.peekLast()) {
      nextPredecessor(predecessors);
    }
    while (k-- > 0) {
      if (predecessors.isEmpty()) {
        result.add(nextSuccessors(successors));
      } else if (successors.isEmpty()) {
        result.add(nextPredecessor(predecessors));
      } else {
        int prev = predecessors.peekLast().val;
        int successor = successors.peekLast().val;
        if (target - prev > successor - target) {
          result.add(nextSuccessors(successors));
        } else {
          result.add(nextPredecessor(predecessors));
        }
      }
    }
    return result;
  }

  private int nextPredecessor(Deque<TreeNode> predecessors) {
    assert !predecessors.isEmpty();
    TreeNode curNode = predecessors.removeLast();
    int result = curNode.val;
    curNode = curNode.left;
    while (curNode != null) {
      predecessors.addLast(curNode);
      curNode = curNode.right;
    }
    return result;
  }

  private int nextSuccessors(Deque<TreeNode> successors) {
    assert !successors.isEmpty();
    TreeNode curNode = successors.removeLast();
    int result = curNode.val;
    curNode = curNode.right;
    while (curNode != null) {
      successors.addLast(curNode);
      curNode = curNode.left;
    }
    return result;
  }

  private Deque<TreeNode> getPredecessor(TreeNode root, double target) {
    Deque<TreeNode> result = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null) {
      if (cur.val == target) {
        result.addLast(cur);
        break;
      } else if (cur.val < target) {
        result.addLast(cur);
        cur = cur.right;
      } else {
        cur = cur.left;
      }
    }
    return result;
  }

  private Deque<TreeNode> getSuccessors(TreeNode root, double target) {
    Deque<TreeNode> result = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null) {
      if (cur.val == target) {
        result.addLast(cur);
        break;
      } else if (cur.val > target) {
        result.addLast(cur);
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
    return result;
  }

  // --------------------------- O N Solution ---------------------------------------
  /**
   * O N solution
   * @param root
   * @param target
   * @param k
   * @return
   */
  private List<Integer> oNSolution(TreeNode root, double target, int k) {
    Deque<Integer> precessors = new ArrayDeque<>();
    Deque<Integer> successors = new ArrayDeque<>();

    findProcessor(root, target, precessors, successors);
    return findClosetK(precessors, successors, target, k );
  }

  private List<Integer> findClosetK(Deque<Integer> precessors, Deque<Integer> successors,
                                    double target, int k) {
    List<Integer> result = new ArrayList<>();
    while (k-- > 0) {
      double sucessorBias = successors.isEmpty()? Integer.MAX_VALUE: successors.peekLast() -
          target;
      double predececorBias = precessors.isEmpty()? Integer.MAX_VALUE: target - precessors
          .peekLast() ;
      if (successors.isEmpty()){
        result.add(precessors.removeLast());
      } else if (precessors.isEmpty()) {
        result.add(successors.removeLast());
      } else if (sucessorBias > predececorBias) {
        result.add(precessors.removeLast());
      } else {
        result.add(successors.removeLast());
      }
    }
    return result;
  }

  private void findProcessor(TreeNode root, double target, Deque<Integer> precessors,
                             Deque<Integer> successors) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if((double) root.val < target) {
          precessors.addLast(root.val);
        } else {
          successors.addFirst(root.val);
        }
        root = root.right;
      }
    }
  }

}
