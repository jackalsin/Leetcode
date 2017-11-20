package _401_450._422_Valid_Word_Square;

import java.util.List;

public class Solution {
  /**
   * "abcd",
   * "bnrt",
   * "crmy",
   * "dtye"
   *
   * @param words
   * @return
   */
  public boolean validWordSquare(List<String> words) {
    if (words == null || words.size() == 0) {
      return true;
    }
    if (words.get(0).length() != words.size()) {
      return false;
    }

    for (int row = 0; row < words.size(); row++) {
      for (int col = 0; col < words.get(row).length(); col++) {
        if (col >= words.get(row).length() || col >= words.size() || row >= words.get(col)
            .length()) {
          return false;
        }
        if (words.get(row).charAt(col) != words.get(col).charAt(row)) {
          return false;
        }
      }
    }
    return true;
  }
}
