package airbnb._773_Sliding_Puzzle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/5/2021
 */
public final class SolutionII implements Solution {
  private static final int N = 6;
  private static final int[][] DIRS = {
      {1, 3},
      {0, 2, 4},
      {1, 5},
      {0, 4},
      {1, 3, 5},
      {2, 4},
  };

  private static final int TARGET = 123450;

  public int slidingPuzzle(int[][] board) {
    final int[] start = getArray(board);
    final Set<Integer> visited = new HashSet<>() {{
      add(getInt(start));
    }};
    final Queue<int[]> q = new ArrayDeque<>() {{
      add(start);
    }};
    if (TARGET == getInt(start)) return 0;
    int step = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final int[] toRemove = q.remove();
        final int zeroIndex = getZeroIndex(toRemove);
        final int[] nextDirs = DIRS[zeroIndex];
        for (final int otherIndex : nextDirs) {
          swap(toRemove, zeroIndex, otherIndex);
          final int nextInt = getInt(toRemove);
          if (nextInt == TARGET) return step + 1;
          if (visited.add(nextInt)) {
            final int[] next = new int[N];
            System.arraycopy(toRemove, 0, next, 0, N);
            q.add(next);
          }
          swap(toRemove, zeroIndex, otherIndex);
        }
      }
      step++;
    }
    return -1;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private static int getZeroIndex(final int[] toRemove) {
    for (int i = 0; i < toRemove.length; ++i) {
      if (toRemove[i] == 0) return i;
    }
    throw new IllegalStateException("Not able to find zero in " + Arrays.toString(toRemove));
  }

  private static int getInt(final int[] arr) {
    int res = 0;
    for (int n : arr) {
      res = res * 10 + n;
    }
    return res;
  }

  private static int[] getArray(final int[][] board) {
    final int cols = board[0].length;
    final List<Integer> result = new ArrayList<>();
    for (int[] ints : board) {
      for (int j = 0; j < cols; ++j) {
        result.add(ints[j]);
      }
    }
    return result.stream().mapToInt(x -> x).toArray();
  }
}
