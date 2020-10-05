package byteDance.hibernation;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  private static final int K = 4;

  @Override
  public int get(int N) {
    final int[] toAdd = new int[N + 1];
    final Queue<Integer> q = new ArrayDeque<>() {{
      add(1);
    }};
    int count = 1;
    for (int i = 1; i <= N; ++i) {
      if (q.size() >= K) {
        final int newAdd = q.remove();
        for (int d = 0; d < K && i + d <= N; ++d) {
          toAdd[i + d] += newAdd;
        }
      }
      q.add(toAdd[i]);
      count += toAdd[i];
    }
    return count;
  }
}
