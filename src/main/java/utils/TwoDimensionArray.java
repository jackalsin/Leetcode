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

  public static void display(char[][] array) {
    if (array == null) {
      throw new NullPointerException("array cannot be null");
    }
    System.out.println("[");
    for (char[] child : array) {
      System.out.println("\t" + Arrays.toString(child));
    }
    System.out.println("]");
  }

  public static void display(long[][] array) {
    if (array == null) {
      throw new NullPointerException("array cannot be null");
    }
    System.out.println("[");
    for (long[] child : array) {
      System.out.println("\t" + Arrays.toString(child));
    }
    System.out.println("]");
  }

  public static void display(final String[][] dp) {
  /*  final int maxLen = Arrays.stream(dp).max(new Comparator<String[]>() {
      @Override
      public int compare(String[] o1, String[] o2) {
        int o1Max = Arrays.stream(o1).max(new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            return -Integer.compare(o1 == null ? 4:o1.length(), o2 == null ? 4 : o2.length());
          }
        }).get().length();
        int o2Max = o2 == null ? 4 : Arrays.stream(o2).max(new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            return -Integer.compare(o1 == null ? 4:o1.length(), o2 == null ? 4 : o2.length());
          }
        }).get().length();
        return -Integer.compare(o1Max, o2Max);
      }
    }).get().length;*/
    int maxLen = 4;
    for (final String[] row : dp) {
      if (row == null) {
        maxLen = Math.max(4, maxLen);
      } else {
        for (final String val : row) {
          int curLen = val == null ? 4 : val.length();
          maxLen = Math.max(curLen, maxLen);
        }
      }
    }
    for (final String[] row : dp) {
      for (final String val : row) {
        final String padding = getPadding(val, maxLen + 1);
        System.out.print(padding);
        System.out.print(val);
      }
      System.out.println();
    }
    System.out.println();
  }

  private static String getPadding(String val, int len) {
    final StringBuilder sb = new StringBuilder();
    final int indent = val == null ? 4 : val.length();
    for (int i = 0; i < len - indent; i++) {
      sb.append(" ");
    }
    return sb.toString();
  }

  public static void display(int[][] array) {
    if (array == null) {
      throw new NullPointerException("array cannot be null");
    }
    System.out.println("[");
    for (int[] child : array) {
      System.out.println("\t" + Arrays.toString(child));
    }
    System.out.println("]");
  }

  public static void display(boolean[][] array) {
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

  /**
   * Get a char board from <tt>strs</tt>.
   *
   * @param strs an non-empty string arrays whose elements have the same length
   */
  public static int[][] getIntBoard(String[] strs) {
    final char[][] charBoard = getCharBoard(strs);
    final int[][] intBoard = new int[charBoard.length][charBoard[0].length];
    for (int row = 0; row < charBoard.length; row++) {
      for (int col = 0; col < charBoard[0].length; col++) {
        intBoard[row][col] = charBoard[row][col] - '0';
      }
    }
    return intBoard;
  }
}
