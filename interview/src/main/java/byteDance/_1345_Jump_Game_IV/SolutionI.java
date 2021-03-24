package byteDance._1345_Jump_Game_IV;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/24/2021
 */
public final class SolutionI implements Solution {
  private final Map<Integer, List<Integer>> valToIndex = new HashMap<>();

  public int minJumps(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return 0;
    }
    final int n = nums.length;
    for (int i = 0; i < n; ++i) {
      valToIndex.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }
    final boolean[] visited = new boolean[n];
    visited[0] = true;
    int steps = 0;
    final Queue<Integer> q = new ArrayDeque<>() {{
      add(0);
    }};
    while (!q.isEmpty()) {
      final int size = q.size();
      ++steps;
      for (int i = 0; i < size; ++i) {
        final int toRemove = q.remove();
        final List<Integer> nexts = valToIndex.get(nums[toRemove]);
        for (int next : nexts) {
          if (visited[next]) continue;
          visited[next] = true;
          if (next == n - 1) {
            return steps;
          }
          q.add(next);
        } // for loop next
        nexts.clear();
        if (toRemove + 1 == n - 1 || n - 1 == toRemove - 1) {
          return steps;
        }
        if (toRemove + 1 < n) {
          visited[toRemove + 1] = true;
          q.add(toRemove + 1);
        }
        if (toRemove - 1 >= 0) {
          visited[toRemove - 1] = true;
          q.add(toRemove - 1);
        }
      }
    }

    return steps;
  }

}
