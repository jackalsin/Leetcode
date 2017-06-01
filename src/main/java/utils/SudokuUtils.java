package utils;

/**
 * @author jacka
 * @version 1.0 on 2/16/2017.
 */
public class SudokuUtils {
  private SudokuUtils() {}
  public static char[][] create2dSudokuArray(String[] input) {
    if (input == null) {
      throw new NullPointerException("input cannot be null");
    }
    if (input.length == 0 || input[0].length() == 0) {
      throw new IllegalArgumentException("input cannot be void");
    }
    if (input.length != 9) {
      throw new IllegalArgumentException("the input length must be 9, now is " + input.length);
    }
    char[][] boards = new char[9][9];

    for (int i = 0; i < 9; i++) {
      String curChars = input[i];
      if (curChars.length() != 9) {
        throw new IllegalArgumentException("input[" + i + "] length must be 9");
      }

      for (int j = 0; j < 9; j++) {
        boards[i][j] = curChars.charAt(j);
      }
    }
    return boards;
  }

}
