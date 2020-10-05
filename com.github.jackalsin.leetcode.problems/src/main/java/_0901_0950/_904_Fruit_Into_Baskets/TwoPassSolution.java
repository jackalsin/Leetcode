package _0901_0950._904_Fruit_Into_Baskets;

import java.util.HashMap;
import java.util.Map;

public final class TwoPassSolution implements Solution {
  public int totalFruit(int[] tree) {
    final Map<Integer, Integer> counts = new HashMap<>();
    int left = 0, maxLen = 0;
    for (int right = 0; right < tree.length; ++right) {
      final int t = tree[right];
      counts.put(t, counts.getOrDefault(t, 0) + 1);
      while (counts.size() > 2) {
        final int leftTree = tree[left];
        counts.put(leftTree, counts.get(leftTree) - 1);
        if (counts.get(leftTree) == 0) {
          counts.remove(leftTree);
        }
        left++;
      }
      maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
  }
}
