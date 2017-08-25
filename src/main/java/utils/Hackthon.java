package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class Hackthon {
  private int[][] board = new int[4][4];

  public static void main(String[] args) {
    Set<Integer> cands = new HashSet<>();
    for (int i = 1; i <= 16; i++) {
      cands.add(i);
    }

    Hackthon hackthon = new Hackthon();
    hackthon.helper(0, cands);
  }

  private void helper(int count, Set<Integer> candidates) {
    if (count == 16) {
      if(row1() && row2() && row3() && row4() && col1() && col2() && col3() && col4()) {
        display2D(board);
      }
    } else {
      int row = count / 4;
      int col = count % 4;
      if (row >= 1 && !row1()) {
        return;
      }
      if (row >= 2 && !row2()) {
        return;
      }
      if (row >= 3 && !row3()) {
        return;
      }

      Set<Integer> dup = new HashSet<>(candidates);
      for (int child : candidates) {
        dup.remove(child);
        board[row][col] = child;
        helper(count + 1, dup);
        dup.add(child);
      }
    }
  }

  private static void display2D(int[][] board) {
    for (int row = 0; row < 4; row++) {
      System.out.println(Arrays.toString(board[row]));
    }
  }

  private boolean row1() {
    return board[0][0] - board[0][1] + board[0][2] + board[0][3] == 12;
  }

  private boolean row2() {
    return board[1][0] - board[1][1] - board[1][2] / board[1][3] == -8;
  }

  private boolean row3() {
    return board[2][0] / board[2][1] + board[2][2] - board[2][3] == 9;
  }

  private boolean row4() {
    return board[3][0] - board[3][1] - board[3][2] + board[3][3] == 4;
  }

  private boolean col1() {
    return board[0][0] + board[1][0] * board[2][0] - board[3][0] == 59;
  }

  private boolean col2() {
    return board[0][1] * board[1][1] / board[2][1] + board[3][1] == 49;
  }

  private boolean col3() {
    return board[0][2] - board[1][2] - board[2][2] * board[3][2] == -19;
  }

  private boolean col4() {
    return board[0][3] / board[1][3] * board[2][3] + board[3][3] == 37;
  }
}
