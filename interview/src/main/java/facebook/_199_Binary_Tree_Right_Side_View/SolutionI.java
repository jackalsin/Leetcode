package facebook._199_Binary_Tree_Right_Side_View;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {

  @Override
  public List<Integer> rightSideView(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    rightSideView(root, result, 0);
    return result;
  }

  private static void rightSideView(final TreeNode root, final List<Integer> result, final int index) {
    if (root == null) return;
    if (result.size() == index) {
      result.add(root.val);
    }
    rightSideView(root.right, result, index + 1);
    rightSideView(root.left, result, index + 1);
  }
}
