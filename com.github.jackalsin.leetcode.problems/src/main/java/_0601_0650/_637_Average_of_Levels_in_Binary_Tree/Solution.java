package _0601_0650._637_Average_of_Levels_in_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Double> averageOfLevels(TreeNode root) {
    final List<Double> sum = new ArrayList<>();
    final List<Integer> levelCount = new ArrayList<>();
    dfs(sum, levelCount, root, 0);

    // get average.
    for (int i = 0; i < levelCount.size(); i++) {
      int count = levelCount.get(i);
      sum.set(i, sum.get(i) / count);
    }

    return sum;
  }

  private static void dfs(final List<Double> sum, final List<Integer> levelCount,
                          final TreeNode root, final int depth) {
    if (root == null) {
      return;
    }

    if (sum.size() <= depth) {
      sum.add(0D);
      levelCount.add(0);
    }
    sum.set(depth, sum.get(depth) + root.val);
    levelCount.set(depth, levelCount.get(depth) + 1);
    dfs(sum, levelCount, root.left, depth + 1);
    dfs(sum, levelCount, root.right, depth + 1);
  }
}
