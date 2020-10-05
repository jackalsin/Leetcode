package _1351_1400._1382_Balance_a_Binary_Search_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public class Solution {
  public TreeNode balanceBST(TreeNode root) {
    if (root == null) return root;
    final List<Integer> vals = new ArrayList<>();
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || root != null) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        vals.add(root.val);
        root = root.right;
      }
    }
    return build(vals, 0, vals.size() - 1);
  }

  private static TreeNode build(final List<Integer> vals, final int left, int right) {
    if (left > right) {
      return null;
    }
    final int index = left + (right - left) / 2;
    final TreeNode root = new TreeNode(vals.get(index));
    root.left = build(vals, left, index - 1);
    root.right = build(vals, index + 1, right);
    return root;
  }
}
