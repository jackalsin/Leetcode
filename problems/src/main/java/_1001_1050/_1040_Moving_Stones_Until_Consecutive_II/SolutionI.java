package _1001_1050._1040_Moving_Stones_Until_Consecutive_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] numMovesStonesII(int[] stones) {
    Arrays.sort(stones);
    final int n = stones.length;
    return new int[]{min(stones), max(stones)};
  }

  private int max(final int[] stones) {
    final int n = stones.length;
    return Math.max(max(stones, 1, n - 1), max(stones, 0, n - 2));
  }

  private static int max(final int[] stones, final int left, final int right) {
    final int empty = stones[right] - stones[left] - 1, people = right - left - 1;
    return Math.max(0, empty - people);
  }

  private int min(final int[] stones) {
    final int n = stones.length;
    int min = Integer.MAX_VALUE;
    for (int i = 0, j = 0; j < n; ++j) {
      while (stones[j] - stones[i] >= n) ++i;
      final int stoneInWindow = j - i + 1;
      /*只需要考虑 中间window 已经有n - 1个石头，仅差一个endpoint move
       * 如果不是上述情况, [3, 4, 7, 8], i = 0, j = 1, 则完全可以move 8 -> 6, 7 -> 5*/
      if (stoneInWindow == n - 1 && stones[j] - stones[i] == n - 2) {
        min = Math.min(min, 2);
      } else {
        min = Math.min(min, n - stoneInWindow);
      }
    }
    return min;
  }
}
