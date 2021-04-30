package google.candyCrushGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 4/28/2021
 */
public final class CandyCrushImpl implements CandyCrush {
  //  private static final int[][][] PATTERNS = {
//      {{0, 0}, {0, 1}, {-1, 2}, {0, 2}},
//      {{0, 0}, {0, 1}, {1, 2}},
//      {{0, 0}, {0, 1}, {0, 3}},
//
//      {{0, 0}, {1, 1}, {1, 2}},
//      {{0, 0}, {-1, 1}, {-1, 2}},
//      {{0, 0}, {0, 2}, {0, 3}},
//  };
  private static final Pattern[] PATTERNS = {
      new Pattern(new int[][]{{0, 2}, {1, 0}, {1, 1}}, new int[]{1, 2}),
      new Pattern(new int[][]{{0, 0}, {0, 1}, {1, 2}}, new int[]{0, 2}),
      new Pattern(new int[][]{{0, 0}, {0, 1}, {0, 3}}, new int[]{0, 2}),

      new Pattern(new int[][]{{0, 0}, {1, 1}, {1, 2}}, new int[]{1, 0}),
      new Pattern(new int[][]{{0, 1}, {0, 2}, {1, 0}}, new int[]{0, 0}),
      new Pattern(new int[][]{{0, 0}, {0, 2}, {0, 3}}, new int[]{0, 1}),

      new Pattern(new int[][]{{0, 1}, {1, 0}, {2, 0}}, new int[]{0, 0}),
      new Pattern(new int[][]{{0, 0}, {1, 1}, {2, 1}}, new int[]{0, 1}),
      new Pattern(new int[][]{{0, 0}, {0, 2}, {0, 3}}, new int[]{0, 1}),

      new Pattern(new int[][]{{0, 1}, {1, 1}, {2, 0}}, new int[]{2, 1}),
      new Pattern(new int[][]{{0, 0}, {1, 0}, {2, 1}}, new int[]{2, 0}),
      new Pattern(new int[][]{{0, 0}, {1, 0}, {3, 0}}, new int[]{2, 0}),
  };
  private final Random rand = new Random();
  private static final int COLORS = 5, UNASSIGN = -1;
  private final int rows, cols;

  public CandyCrushImpl(final int rows, final int cols) {
    this.rows = rows;
    this.cols = cols;
  }

  public int[][] getBoard() {
    final int[][] board = new int[rows][cols];
    while (true) {
      for (final int[] row : board) {
        Arrays.fill(row, UNASSIGN);
      }
      if (initBoard(board)) {
        return board;
      }
    }
  }

  private boolean initBoard(final int[][] board) {
    final int[] solutionColors = getSolutionColor(); // 2
    final Pattern solutionPattern = PATTERNS[rand.nextInt(PATTERNS.length)];
    final int solutionRow = rand.nextInt(rows - solutionPattern.rows),
        solutionCol = rand.nextInt(cols - solutionPattern.cols);
    // add solution
    for (final int[] valid : solutionPattern.solutions) {
      board[solutionRow + valid[0]][solutionCol + valid[1]] = solutionColors[0];
    }
    board[solutionRow + solutionPattern.invalid[0]][solutionCol + solutionPattern.invalid[1]] = solutionColors[1];

    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (board[row][col] != UNASSIGN) continue;
        final Set<Integer> invalidColors = getInvalidSet(board, row, col);
        final int selectColor = getColor(invalidColors);
        if (selectColor == UNASSIGN) return false; // invalid
        board[row][col] = selectColor;
      }
    }
    return true;
  }

  int getColor(final Collection<Integer> invalidColors) {
    return getColor(new ArrayList<>(invalidColors));
  }

  private int getColor(final List<Integer> invalidColors) {
    final TreeMap<Integer, Integer> treeMap = new TreeMap<>() {{
      put(0, 0);
    }};
    Collections.sort(invalidColors);
    for (int i = 0; i < invalidColors.size(); ++i) {
      treeMap.put(invalidColors.get(i), i + 1);
    }
    final int rand = this.rand.nextInt(COLORS - invalidColors.size()),
        diff = treeMap.floorEntry(rand).getValue();
    return rand + diff;
  }

  private Set<Integer> getInvalidSet(final int[][] board, final int row, final int col) {
    final Set<Integer> result = new HashSet<>();
    if (row - 2 >= 0 && board[row - 1][col] == board[row - 2][col]) {
      result.add(board[row - 1][col]);
    }
    if (col - 2 >= 0 && board[row][col - 1] == board[row][col - 2]) {
      result.add(board[row][col - 1]);
    }
    return result;
  }

  int[] getSolutionColor() {
    final int first = rand.nextInt(COLORS), second = getColor(new ArrayList<>() {{
      add(first);
    }});
    return new int[]{first, second};
  }

  private static final class Pattern {
    private final int[][] solutions;
    private final int[] invalid;
    private final int rows, cols;

    private Pattern(int[][] solutions, int[] invalid) {
      this.solutions = solutions;
      this.invalid = invalid;
      int maxRows = 0, maxCols = 0, minRows = Integer.MAX_VALUE, minCols = Integer.MAX_VALUE;
      for (final int[] solution : solutions) {
        maxRows = Math.max(maxRows, solution[0]);
        minRows = Math.min(minRows, solution[0]);
        maxCols = Math.max(maxCols, solution[1]);
        minCols = Math.min(minCols, solution[1]);
      }
      this.rows = maxRows - minRows;
      this.cols = maxCols - minCols;
    }
  }
}
