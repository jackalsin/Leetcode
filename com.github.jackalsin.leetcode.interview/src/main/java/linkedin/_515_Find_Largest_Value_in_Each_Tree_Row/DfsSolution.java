package linkedin._515_Find_Largest_Value_in_Each_Tree_Row;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/9/2019
 */
public final class DfsSolution implements Solution {
  @Override
  public List<Integer> largestValues(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    largestValues(root, result, 0);
    return result;
  }

  private static void largestValues(final TreeNode root,
                                    final List<Integer> result,
                                    final int depth) {
    if (root == null) {
      return;
    }
    if (result.size() == depth) {
      result.add(root.val);
    } else {
      int max = Math.max(root.val, result.get(depth));
      result.set(depth, max);
    }
    largestValues(root.left, result, depth + 1);
    largestValues(root.right, result, depth + 1);
  }
}
