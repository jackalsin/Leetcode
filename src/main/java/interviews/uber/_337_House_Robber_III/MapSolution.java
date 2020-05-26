package interviews.uber._337_House_Robber_III;

import utils.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MapSolution implements Solution {
  private final Map<TreeNode, Integer> maxSoFar = new HashMap<>();

  /**
   * 124 / 124 test cases passed.
   * Status: Accepted
   * Runtime: 11 ms
   *
   * @param root
   * @return
   */
  public int rob(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (maxSoFar.containsKey(root)) {
      return maxSoFar.get(root);
    }
    int res = 0;
    if (root.left != null) {
      res += rob(root.left.left);
      res += rob(root.left.right);
    }

    if (root.right != null) {
      res += rob(root.right.left);
      res += rob(root.right.right);
    }
    res = Math.max(res + root.val, rob(root.left) + rob(root.right));

    maxSoFar.put(root, res);

    return res;
  }
}
