package _1401_1450._1424_Diagonal_Traverse_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class SolutionI implements Solution {
  @Override
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    final Map<Integer, LinkedList<Integer>> sumToElements = new HashMap<>();
    int max = 0;
    for (int row = 0; row < nums.size(); ++row) {
      final List<Integer> curRow = nums.get(row);
      for (int col = 0; col < curRow.size(); ++col) {
        final int key = row + col;
        max = Math.max(key, max);
        sumToElements.computeIfAbsent(key, k -> new LinkedList<>()).addFirst(nums.get(row).get(col));
      }
    }
    final List<Integer> result = new ArrayList<>();
    for (int sum = 0; sum <= max; sum++) {
      final List<Integer> cur = sumToElements.getOrDefault(sum, new LinkedList<>());
      result.addAll(cur);
    }

    return getArray(result);
  }

  private static int[] getArray(final List<Integer> src) {
    final int[] result = new int[src.size()];
    for (int i = 0; i < src.size(); ++i) {
      result[i] = src.get(i);
    }
    return result;
  }
}
