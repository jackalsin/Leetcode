package _651_700._656_Coin_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<Integer> cheapestJump(int[] A, int B) {
    final int N = A.length;
    if (N == 0) {
      return new ArrayList<>();
    }
    final int[] cost = new int[N];
    Arrays.fill(cost, Integer.MAX_VALUE);
    final List<List<Integer>> minCostPath = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      minCostPath.add(new ArrayList<>());
    }
    cost[0] = A[0];
    minCostPath.get(0).add(1);
    for (int i = 0; i < N; i++) {
      if (A[i] == -1) {
        continue;
      }
      for (int step = 1; step <= B && i + step < N; step++) {
        if (A[i + step] == -1) {
          continue;
        }
        if (cost[i] == Integer.MAX_VALUE) {
          continue;
        }
        int newCost = cost[i] + A[i + step];
        if (cost[i + step] > newCost) {
          cost[i + step] = newCost;
          List<Integer> newPath = new ArrayList<>(minCostPath.get(i));
          newPath.add(i + step + 1);
          minCostPath.set(i + step, newPath);
        } else if (cost[i + step] == newCost) {
          List<Integer> newPath = new ArrayList<>(minCostPath.get(i));
          newPath.add(i + step + 1);
          List<Integer> oldPath = minCostPath.get(i + step);
          if (isSmaller(oldPath, newPath)) {
            minCostPath.set(i + step, newPath);
          }
        }
      }
    }
    return minCostPath.get(N - 1);
  }

  private boolean isSmaller(List<Integer> oldPath, List<Integer> newPath) {
    int minLen = Math.min(oldPath.size(), newPath.size());
    for (int i = 0; i < minLen; i++) {
      int cmp = Integer.compare(oldPath.get(i), newPath.get(i));
      if (cmp > 0) {
        return true;
      } else if (cmp < 0) {
        return false;
      }
    }
    return false;
  }
}
