package _0851_0900._864_Shortest_Path_to_Get_All_Key;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public final class BfsSolution implements Solution {
  //grid. "." is an empty cell,
  // "#" is a wall,
  // "@" is the starting point,
  private static final char EMPTY = '.', WALL = '#', START = '@';
  // ("a", "b", ...) are keys, and ("A", "B", ...) are locks.
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int shortestPathAllKeys(String[] grid) {
    if (grid.length == 0 || grid[0].length() == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length();
    int startRow = -1, startCol = -1, targetKeys = 0;
    // get start point and keys count
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        final char chr = grid[row].charAt(col);
        if (chr == START) {
          startRow = row;
          startCol = col;
        } else if (isKey(chr)) {
          targetKeys = addKey(targetKeys, chr);
        }
      }
    }

    if (startRow == -1) {
      assert startCol == -1;
      return -1;
    }
    final Queue<State> q = new ArrayDeque<>();
    final Set<State> visited = new HashSet<>();
    final State start = new State(0, startRow, startCol);
    q.add(start);
    visited.add(start);
    int step = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final State toRemove = q.remove();
        final int curKey = toRemove.keys;
        for (final int[] d : DIRS) {
          final int nextRow = toRemove.row + d[0],
              nextCol = toRemove.col + d[1];
          if (!isInRange(rows, cols, nextRow, nextCol)) {
            continue;
          }
          final char chr = grid[nextRow].charAt(nextCol);
          if (chr == WALL) continue;
          if (isLock(chr) && !hasKey(curKey, chr)) continue;
          final int nextKey = isKey(chr) ? (addKey(curKey, chr)) : curKey;
          if (nextKey == targetKeys) {
            return step + 1;
          }
          final State nextState = new State(nextKey, nextRow, nextCol);
          if (visited.contains(nextState)) {
            continue;
          }
          visited.add(nextState);
          q.add(nextState);
        }
      }
      step++;
    }

    return -1;
  }

  private static boolean isInRange(final int rows, final int cols, int row, int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

  private static int addKey(final int key, final char chr) {
    return key | (1 << (chr - 'a'));
  }

  private static boolean hasKey(final int key, final char chr) {
    assert isLock(chr);
    return ((key >> ((chr - 'A'))) & 1) == 1;
  }

  private static boolean isLock(final char chr) {
    return 'A' <= chr && chr <= 'F';
  }

  private static boolean isKey(final char chr) {
    return 'a' <= chr && chr <= 'f';
  }

  private static final class State {
    private final int keys, row, col;

    private State(int keys, int row, int col) {
      this.keys = keys;
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      State state = (State) o;
      return keys == state.keys &&
          row == state.row &&
          col == state.col;
    }

    @Override
    public int hashCode() {
      return Objects.hash(keys, row, col);
    }
  }
}
