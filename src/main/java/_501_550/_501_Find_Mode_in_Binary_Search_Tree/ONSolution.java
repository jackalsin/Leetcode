package _501_550._501_Find_Mode_in_Binary_Search_Tree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ONSolution implements Solution {
  @Override
  public int[] findMode(TreeNode root) {
    final Map<Integer, Integer> counts = new HashMap<>();
    findMode(counts, root);

    int max = 0;
    Set<Integer> resultList = new HashSet<>();
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      if (entry.getValue() == max) {
        resultList.add(entry.getKey());
      } else if (entry.getValue() > max) {
        resultList.clear();
        resultList.add(entry.getKey());
        max = entry.getValue();
      }
    }

    final int[] res = new int[resultList.size()];
    int i = 0;
    for (int num : resultList) {
      res[i++] = num;
    }
    return res;
  }

  private static void findMode(final Map<Integer, Integer> counts, TreeNode root) {
    if (root == null) {
      return;
    }
    counts.put(root.val, counts.getOrDefault(root.val, 0) + 1);
    findMode(counts, root.left);
    findMode(counts, root.right);
  }
}
