package _201_250._212_Word_Search_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/8/2017.
 */
public class Solution {

  public List<String> findWords(char[][] board, String[] words) {
    Set<String> result = new HashSet<>();
    if (board != null && board.length != 0 && board[0].length != 0) {
      for (String word : words) {
        if (findWord(board, word)) {
          result.add(word);
        }
      }
    }
    return new ArrayList<>(result);
  }

  private boolean findWord(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;
    Set<Coordinate> visited = new HashSet<>();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (isValid(board, word, row, col, 0, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isValid(char[][] board, String word, int startRow, int startCol, int index,
                          Set<Coordinate> visited) {
    int rows = board.length;
    int cols = board[0].length;
    if (index == word.length()) {
      return true;
    } else if (startCol < 0 || startRow < 0 || startCol >= cols || startRow >= rows
        || visited.contains(new Coordinate(startRow, startCol))
        || word.charAt(index) != board[startRow][startCol]) {
      return false;
    } else {
      Coordinate curCoordinate = new Coordinate(startRow, startCol);
      visited.add(curCoordinate);
      boolean result = isValid(board, word, startRow + 1, startCol, index + 1, visited)
          ||isValid(board, word, startRow - 1, startCol, index + 1, visited)
          ||isValid(board, word, startRow, startCol + 1, index + 1, visited)
          ||isValid(board, word, startRow, startCol - 1, index + 1, visited);
      visited.remove(curCoordinate);
      return result;
    }
  }

  /**
   * Class to represent coordinate
   */
  private static final class Coordinate {
    private final int row;
    private final int col;

    Coordinate(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Coordinate)) {
        return false;
      }

      Coordinate coordinate = (Coordinate) o;

      return row == coordinate.row && col == coordinate.col;
    }

    @Override
    public int hashCode() {
      int result = row;
      result = 31 * result + col;
      return result;
    }
  }
}
