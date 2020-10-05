package linkedin._199_Binary_Tree_Right_Side_View;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    rightSideView(result, root, 0);
    return result;
  }

  private void rightSideView(final List<Integer> result, final TreeNode root, final int i) {
    if (root == null) {
      return;
    }
    if (result.size() <= i) {
      result.add(root.val);
    }
    rightSideView(result, root.right, i + 1);
    rightSideView(result, root.left, i + 1);
  }
}
