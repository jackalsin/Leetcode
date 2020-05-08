package interviews.byteDance._199_Binary_Tree_Right_Side_View;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> rightSideView(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    rightSideView(result, root, 0);
    return result;
  }

  private static void rightSideView(final List<Integer> result, final TreeNode root, final int depth) {
    if (root == null) {
      return;
    }
    if (depth == result.size()) {
      result.add(root.val);
    } else {
      result.set(depth, root.val);
    }
    rightSideView(result, root.left, depth + 1);
    rightSideView(result, root.right, depth + 1);
  }
}
