package _0101_0150._110_Balanced_Binary_Tree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 6/20/2017.
 */
public class Solution {
  private final Map<TreeNode, Integer> heights = new HashMap<>();

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    } else {
      return isBalanced(root.left) && isBalanced(root.right) &&
          Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      if (heights.containsKey(root)) {
        return heights.get(root);
      } else {
        int curHeight = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        heights.put(root, curHeight);
        return curHeight;
      }
    }
  }
}
