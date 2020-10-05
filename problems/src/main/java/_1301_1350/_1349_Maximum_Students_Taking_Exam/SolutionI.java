package _1301_1350._1349_Maximum_Students_Taking_Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public final class SolutionI implements Solution {
  private static final char E = '.';
  private int rows, cols;

  public int maxStudents(char[][] seats) {
    if (seats == null || seats.length == 0) {
      return 0;
    }
    rows = seats.length;
    cols = seats[0].length;
    final int[] normedRows = getNormedRows(seats);
//    Arrays.stream(normedRows).forEach(x -> System.out.println(Integer.toBinaryString(x)));
    final int state = 1 << cols;
    final int[][] dp = new int[rows][state];
    for (final int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return getMax(dp, normedRows, 0, 0);
  }

  /**
   * @param dp
   * @param normedRows
   * @param row
   * @param prevRowSeats // 第0排的前一排相当于没人坐着
   * @return
   */
  private int getMax(final int[][] dp, final int[] normedRows, final int row, final int prevRowSeats) {
    if (row == normedRows.length) {
      return 0;
    }
    if (dp[row][prevRowSeats] != -1) {
//      System.out.println("Hit - " + row + ", prevRowSeats = " + prevRowSeats);
      return dp[row][prevRowSeats];
    }
    final List<Integer> curSeats = new ArrayList<>();
    dfs(curSeats, normedRows[row], 0, 0, prevRowSeats);
//    System.out.println("row = " + row + ", prevState = " + Integer.toBinaryString(prevRowSeats) + ", " + curSeats
//    .stream().map(x -> Integer.toBinaryString(x)).collect(Collectors.toList()));
    int res = 0;
    for (int curSeat : curSeats) {
      res = Math.max(res, Integer.bitCount(curSeat) + getMax(dp, normedRows, row + 1, curSeat));
    }
    dp[row][prevRowSeats] = res;
    return res;
  }

  private void dfs(final List<Integer> result, final int normedCurRow, final int col, int curRowSeats,
                   final int prevRowSeats) {
    if (col == cols) {
      result.add(curRowSeats);
      return;
    }
    // don't sit
    // error: prevState = 1,
    dfs(result, normedCurRow, col + 1, curRowSeats, prevRowSeats);
    if (
        ((normedCurRow >> (cols - 1 - col)) & 1) == 1 // this is an empty seat
            && (col == 0 || ((curRowSeats >> (cols - 1 - col + 1)) & 1) == 0) // left
            && (col == cols - 1 || ((curRowSeats >> (cols - 1 - col - 1)) & 1) == 0) // right
            && (col == 0 || ((prevRowSeats >> (cols - 1 - col + 1)) & 1) == 0) // up left
            && (col == cols - 1 || ((prevRowSeats >> (cols - 1 - col - 1)) & 1) == 0) // up right
    ) {
//      System.out.println("row = " + Integer.toBinaryString(normedCurRow) + ", col = " + col + ", pre = " +
//      prevRowSeats);
      curRowSeats |= 1 << (cols - 1 - col);
      dfs(result, normedCurRow, col + 1, curRowSeats, prevRowSeats);
      curRowSeats ^= 1 << (cols - 1 - col);
    }
  }

  private static int[] getNormedRows(char[][] seats) {
    final int rows = seats.length, cols = seats[0].length;
    final int[] res = new int[rows];
    for (int row = 0; row < rows; row++) {
      int cur = 0;
      for (int col = 0; col < cols; ++col) {
        cur <<= 1;
        if (seats[row][col] == E) {
          cur |= 1;
        }
      }
      res[row] = cur;
    }
    return res;
  }
}
