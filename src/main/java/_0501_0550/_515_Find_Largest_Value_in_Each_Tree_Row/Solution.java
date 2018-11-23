package _0501_0550._515_Find_Largest_Value_in_Each_Tree_Row;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class Solution {

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    largestValues(result, root, 0);
    return result;
  }

  private void largestValues(List<Integer> result, TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    if (result.size() <= depth) {
      result.add(Integer.MIN_VALUE);
    }
    largestValues(result, root.left, depth + 1);
    largestValues(result, root.right, depth + 1);
    result.set(depth, Math.max(result.get(depth), root.val));
  }
}
