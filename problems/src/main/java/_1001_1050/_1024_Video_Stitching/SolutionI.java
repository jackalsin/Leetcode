package _1001_1050._1024_Video_Stitching;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 10/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int videoStitching(int[][] clips, int T) {
    if (clips == null || clips.length == 0) {
      return 0;
    }
    final int[] dp = new int[T + 1];
    final TreeMap<Integer, int[]> startToIntervals = new TreeMap<>();
    for (final int[] clip : clips) {
      if (startToIntervals.containsKey(clip[0])) {
        final int[] cur = startToIntervals.get(clip[0]);
        if (cur[1] - cur[0] < clip[1] - clip[0]) {
          startToIntervals.put(clip[0], clip);
        }
      } else {
        startToIntervals.put(clip[0], clip);
      }
    }
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (final var e : startToIntervals.entrySet()) {
      final int[] cur = e.getValue();
      final int start = cur[0], end = cur[1];
      if (start > T || dp[start] == Integer.MAX_VALUE) continue;
      for (int j = start + 1; j <= Math.min(T, end); j++) {
        dp[j] = Math.min(dp[j], dp[start] + 1);
      }
    }
    return dp[T] == Integer.MAX_VALUE ? -1 : dp[T];
  }
}
