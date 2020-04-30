package _1301_1350._1340_Jump_Game_V;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/29/2020
 */
public final class ReverseJumpSolution implements Solution {
  private final Map<Integer, List<Integer>> graph = new HashMap<>();

  public int maxJumps(int[] arr, int d) {
    final int n = arr.length;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        final int j = stack.pop();
        if (Math.abs(i - j) <= d) graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
      }
      stack.push(i);
    }
    stack.clear();
    for (int i = n - 1; i >= 0; --i) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        final int j = stack.pop();
        if (Math.abs(i - j) <= d) graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
      }
      // 此处一个单调栈，始终储存比自己高的点的index
      stack.push(i);
    }
    System.out.println(graph);
    final int[] heights = getHeights(arr);
    int max = 0;
    for (int h : heights) {
      max = Math.max(h, max);
    }
    return max;
  }

  private int[] getHeights(final int[] arr) {
    final int n = arr.length;
    final int[] heights = new int[n];
    for (int i = 0; i < n; ++i) {
      heights[i] = getHeights(heights, i);
    }
    return heights;
  }

  private int getHeights(final int[] heights, final int i) {
    if (heights[i] != 0) {
      return heights[i];
    }
    int cur = 1;
    for (int n : graph.getOrDefault(i, new ArrayList<>())) {
      cur = Math.max(cur, 1 + getHeights(heights, n));
    }
    return cur;
  }

}
