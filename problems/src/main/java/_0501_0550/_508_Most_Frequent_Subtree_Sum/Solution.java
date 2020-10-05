package _0501_0550._508_Most_Frequent_Subtree_Sum;

import definition.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  /**
   * 61 / 61 test cases passed.
   * Status: Accepted
   * Runtime: 16 ms
   *
   * @param root
   * @return
   */
  public int[] findFrequentTreeSum(TreeNode root) {
    final Map<Integer, Integer> cache = new HashMap<>();
    sumCount(cache, root);
    return getHigh(cache);
  }

  private static int sumCount(final Map<Integer, Integer> cache, final TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSum = sumCount(cache, root.left), rightSum = sumCount(cache, root.right);
    final int sum = root.val + leftSum + rightSum;
    cache.put(sum, cache.getOrDefault(sum, 0) + 1);
    return sum;
  }

  /**
   * Get highest freq from map.
   *
   * @param cache
   * @return
   */
  private int[] getHigh(Map<Integer, Integer> cache) {
    final List<Integer> result = new ArrayList<>();
    int max = 0;
    for (final Map.Entry<Integer, Integer> entry : cache.entrySet()) {
      final int key = entry.getKey(), value = entry.getValue();
      if (value > max) {
        result.clear();
        result.add(key);
        max = value;
      } else if (value == max) {
        result.add(key);
      }
    }
    final int[] res = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      res[i] = result.get(i);
    }
    return res;
  }
}
