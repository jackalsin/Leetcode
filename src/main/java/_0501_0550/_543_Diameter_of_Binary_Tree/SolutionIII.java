package _0501_0550._543_Diameter_of_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
public final class SolutionIII implements Solution {
  //  private final Map<TreeNode, Integer> cache = new HashMap<>();
  private int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    len(root);
    return max;
  }

  private int len(final TreeNode root) {
    if (root == null) {
      return 0;
    }
//    if (cache.containsKey(root)) {
//      return cache.get(root);
//    }
    final int leftLen = len(root.left), rightLen = len(root.right), res = Math.max(leftLen, rightLen) + 1;
    max = Math.max(max, leftLen + rightLen);
//    cache.put(root, res);
    return res;
  }
}
