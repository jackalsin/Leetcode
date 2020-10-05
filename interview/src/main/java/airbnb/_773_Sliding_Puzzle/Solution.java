package airbnb._773_Sliding_Puzzle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/16/2019.
 */
public final class Solution {
  private static final int N = 6;
  // [[0,1,2],
  // [3,4,5]].
  private static final int[][] DIRS = {
      {1, 3},
      {0, 2, 4},
      {1, 5},
      {0, 4},
      {1, 3, 5},
      {4, 2},
  };

  private static final int TARGET = getRepr(new int[]{
      1, 2, 3, 4, 5, 0
  });

  public int slidingPuzzle(int[][] board) {
    final int[] start = get(board);
    final Set<Integer> visited = new HashSet<>();
    final Queue<int[]> q = new ArrayDeque<>();
    q.add(start);
    final int startRepr = getRepr(start);
    if (startRepr == TARGET) return 0;
    visited.add(startRepr);
    int step = 0;
    while (!q.isEmpty()) {
      step++;
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final int[] toRemove = q.remove();
        int zeroIndex = getZeroIndex(toRemove);
        for (final int d : DIRS[zeroIndex]) {
          final int[] newArr = new int[N];
          System.arraycopy(toRemove, 0, newArr, 0, N);
          swap(newArr, d, zeroIndex);
          final int repr = getRepr(newArr);
          if (visited.contains(repr)) continue;
          if (repr == TARGET) {
            return step;
          }
          q.add(newArr);
          visited.add(repr);
        }
      }
    }
    return -1;
  }

  private static void swap(final int[] arr, final int i, final int j) {
    final int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  private static int[] get(int[][] board) {
    final int[] res = new int[N];
    int i = 0;
    for (int[] row : board) {
      for (int col : row) {
        res[i++] = col;
      }
    }
    return res;
  }

  private static int getRepr(final int[] arr) {
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      res = (res << 4) | arr[i];
    }
    return res;
  }

  private static int getZeroIndex(final int[] array) {
    for (int j = 0; j < N; j++) {
      if (array[j] == 0) {
        return j;
      }
    }
    throw new NoSuchElementException("There is no zero: " + Arrays.toString(array));
  }
}
