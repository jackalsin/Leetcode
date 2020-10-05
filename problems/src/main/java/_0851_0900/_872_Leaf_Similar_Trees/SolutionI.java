package _0851_0900._872_Leaf_Similar_Trees;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    final List<Integer> leave1 = getLeaves(root1),
        leave2 = getLeaves(root2);
    return leave1.equals(leave2);
  }

  private static List<Integer> getLeaves(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (root.left == null && root.right == null) {
          result.add(root.val);
        }
        root = root.right;
      }
    }
    return result;
  }
}
