package utils;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/28/2017.
 */
public final class TwoDimensionArray {
  private TwoDimensionArray() {}

  public static boolean TwoDimensionArrayEquals(char[][] board1, char[][] board2) {
    if (board1 == null) {
      throw new NullPointerException("board1 cannot be null");
    }
    if (board2 == null) {
      throw new NullPointerException("board2 cannot be null");
    }
    if (board1.length == 0 && board2.length == 0) {
      return true;
    }
    if (board1.length != board2.length) {
      return false;
    }
    int rows = board1.length;
    for (int row = 0; row < rows; row++) {
      if (board1[row].length == 0 && board2[row].length == 0) {
        return true;
      }
      if (board1[row].length != board2[row].length) {
        return false;
      }
      int cols = board1[row].length;
      for (int col = 0; col < cols; col++) {
        if (board1[row][col] != board2[row][col]) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean TwoDimensionArrayEquals(int[][] board1, int[][] board2) {
    if (board1 == null) {
      throw new NullPointerException("board1 cannot be null");
    }
    if (board2 == null) {
      throw new NullPointerException("board2 cannot be null");
    }
    if (board1.length == 0 && board2.length == 0) {
      return true;
    }
    if (board1.length != board2.length) {
      return false;
    }
    int rows = board1.length;
    for (int row = 0; row < rows; row++) {
      if (board1[row].length == 0 && board2[row].length == 0) {
        return true;
      }
      if (board1[row].length != board2[row].length) {
        return false;
      }
      int cols = board1[row].length;
      for (int col = 0; col < cols; col++) {
        if (board1[row][col] != board2[row][col]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void display2DimensionArray(char[][] array) {
    if (array == null) {
      throw new NullPointerException("array cannot be null");
    }
    System.out.println("[");
    for (char[] child : array) {
      System.out.println("\t" + Arrays.toString(child));
    }
    System.out.println("]");
  }

  public static void display2DimensionArray(int[][] array) {
    if (array == null) {
      throw new NullPointerException("array cannot be null");
    }
    System.out.println("[");
    for (int[] child : array) {
      System.out.println("\t" + Arrays.toString(child));
    }
    System.out.println("]");
  }

  public static void display2DimensionArray(boolean[][] array) {
    if (array == null) {
      throw new NullPointerException("array cannot be null");
    }
    System.out.println("[");
    for (boolean[] child : array) {
      System.out.println("\t" + Arrays.toString(child));
    }
    System.out.println("]");
  }

  /**
   * Get a char board from <tt>strs</tt>.
   * @param strs  an non-empty string arrays whose elements have the same length
   * @return
   */
  public static char[][] getCharBoard(String[] strs) {
    if (strs == null) {
      throw new NullPointerException("strs cannot be null");
    }
    final int rows = strs.length;
    if (rows == 0) {
      throw new IllegalArgumentException("strs cannot be zero length");
    }
    final int cols = strs[0].length();
    char[][] board = new char[rows][cols];
    for (int row = 0; row < rows; ++row) {
      if (cols != strs[row].length()) {
        throw new IllegalArgumentException("Each row should have the same length with the first " +
            "one = " + cols);
      }
      System.arraycopy(strs[row].toCharArray(), 0, board[row], 0, cols);
    }

    return board;
  }
}
