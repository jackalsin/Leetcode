package _0651_0700._653_Two_Sum_IV_Input_is_a_BST;

import definition.binaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  private final Set<Integer> visited = new HashSet<>();

  public boolean findTarget(TreeNode root, int k) {
    if (root == null) {
      return false;
    }
    if (visited.contains(k - root.val)) {
      return true;
    }
    visited.add(root.val);
    return findTarget(root.left, k) || findTarget(root.right, k);
  }
}
