package airbnb._864_Shortest_Path_to_Get_All_Keys;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/5/2021
 */
public final class SolutionI implements Solution {
  private static final char EMPTY = '.',
      WALL = '#',
      START = '@';
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int shortestPathAllKeys(String[] grid) {
    final Queue<int[]> q = new ArrayDeque<>();
    final Set<State> visited = new HashSet<>();
    int targetKey = 0;
    final int rows = grid.length, cols = grid[0].length();
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        final char c = grid[i].charAt(j);
        if (c == START) {
          q.add(new int[]{i, j, 0});
          visited.add(new State(i, j, 0));
        } else if (isKey(c)) {
          targetKey = addKey(targetKey, c);
        }
      }
    }
    int step = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        // {i, j, key}
        final int[] toRemove = q.remove();
        final int currentKeys = toRemove[2], x = toRemove[0], y = toRemove[1];
        for (final int[] dir : DIRS) {
          final int nextX = x + dir[0], nextY = y + dir[1];
          if (nextX < 0 || nextY < 0 || nextX >= rows || nextY >= cols) continue;
          final char nextC = grid[nextX].charAt(nextY);
          if (nextC == WALL) continue;
          else if (isLock(nextC)) {
            if (hasKey(currentKeys, nextC - LOCK_BASE)
                && visited.add(new State(nextX, nextY, currentKeys))) {
              q.add(new int[]{nextX, nextY, currentKeys});
            }
          } else if (isKey(nextC)) {
            final int nextKeys = addKey(currentKeys, nextC);
            if (nextKeys == targetKey) return step + 1;
            if (visited.add(new State(nextX, nextY, nextKeys))) {
              q.add(new int[]{nextX, nextY, nextKeys});
            }
          } else {
            assert nextC == EMPTY || nextC == START;
            if (visited.add(new State(nextX, nextY, currentKeys))) {
              q.add(new int[]{nextX, nextY, currentKeys});
            }
          }
        }
      } // end of step;
      step++;
    }
    return -1;
  }

  private static boolean isKey(final char c) {
    return Character.isLowerCase(c);
  }

  private static boolean isLock(final char c) {
    return Character.isUpperCase(c);
  }

  private static final char LOCK_BASE = 'A',
      KEY_BASE = 'a';

  private static int addKey(final int prev, final char newKey) {
    return prev | (1 << (newKey - KEY_BASE));
  }

  private static boolean hasKey(final int keys, final int bit) {
    return ((keys >> bit) & 1) == 1;
  }

  private static final class State {
    private final int x, y, currentKeys;

    private State(int x, int y, int currentKeys) {
      this.x = x;
      this.y = y;
      this.currentKeys = currentKeys;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof State)) return false;
      State state = (State) o;
      return x == state.x && y == state.y && currentKeys == state.currentKeys;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y, currentKeys);
    }
  }
}
