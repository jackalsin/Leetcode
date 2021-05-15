package uber._199_Binary_Tree_Right_Side_View;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> rightSideView(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    rightSideView(result, root, 0);
    return result;
  }

  private void rightSideView(final List<Integer> result, final TreeNode root, final int size) {
    if (root == null) return;
    if (result.size() == size) result.add(root.val);
    rightSideView(result, root.right, size + 1);
    rightSideView(result, root.left, size + 1);
  }
}
