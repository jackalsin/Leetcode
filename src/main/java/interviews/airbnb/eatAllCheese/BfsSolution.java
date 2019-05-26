package interviews.airbnb.eatAllCheese;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public final class BfsSolution implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int getShortestPath(char[][] board) {
    if (board == null || board.length == 0) {
      return 0;
    }
    final int rows = board.length, cols = board[0].length;
    int startRow = -1, startCol = -1;
    final Set<Long> targetKeys = new HashSet<>();
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        final char chr = board[row][col];
        if (chr == START) {
          startRow = row;
          startCol = col;
        } else if (chr == KEY) {
          targetKeys.add(getKeyId(row, col));
        }
      }
    }
    int steps = 0;
    final State startState = new State(new HashSet<>(), startRow, startCol);
    final Queue<State> q = new ArrayDeque<>();
    final Set<State> visited = new HashSet<>();
    q.add(startState);
    visited.add(startState);
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final State toRemove = q.remove();
        final int curRow = toRemove.row, curCol = toRemove.col;
        final Set<Long> curKeys = toRemove.cheese;
        for (int[] d : DIRS) {
          final int nextRow = curRow + d[0], nextCol = curCol + d[1];
          if (!isInRange(rows, cols, nextRow, nextCol)) continue;
          final char chr = board[nextRow][nextCol];
          final Set<Long> nextKeys = new HashSet<>(curKeys);
          if (chr == KEY) {
            nextKeys.add(getKeyId(nextRow, nextCol));
          }
          if (nextKeys.equals(targetKeys)) {
            return steps + 1;
          }
          final State nextState = new State(nextKeys, nextRow, nextCol);
          if (visited.contains(nextState)) continue;
          visited.add(nextState);
          q.add(nextState);
        }
      } // end of for
      steps++;
    }
    return steps;
  }

  private static long getKeyId(final int row, final int col) {
    return (((long) row) << 32) | col;
  }

  private static boolean isInRange(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

  private static final class State {
    private final int row, col;
    private final Set<Long> cheese;

    private State(final Set<Long> cheese, int row, int col) {
      this.cheese = new HashSet<>(cheese);
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      State state = (State) o;
      return row == state.row &&
          col == state.col &&
          Objects.equals(cheese, state.cheese);
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col, cheese);
    }

    @Override
    public String toString() {
      return "State{" +
          "row=" + row +
          ", col=" + col +
          ", cheese=" + cheese +
          '}';
    }
  }
}
