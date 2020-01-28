package _0501_0550._545_Boundary_of_Binary_Tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
  private final List<Integer> result = new ArrayList<>();

  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    if (root == null) {
      return result;
    }
    result.add(root.val);
    addLeft(root.left);
    addLeave(root.left);
    addLeave(root.right);
    addRight(root.right);
    return result;
  }

  private void addLeave(TreeNode root) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || root != null) {
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
  }

  private void addLeft(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return;
    }
    result.add(root.val);
    if (root.left == null) {
      addLeft(root.right);
    } else {
      addLeft(root.left);
    }
  }

  private void addRight(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return;
    }
    if (root.right == null) {
      addRight(root.left);
    } else {
      addRight(root.right);
    }
    result.add(root.val);
  }
}
