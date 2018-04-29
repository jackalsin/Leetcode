package _451_500._488_Zuma_Game;

public class Solution {

  /**
   * 106 / 106 test cases passed.
   * Status: Accepted
   * Runtime: 11 ms
   *
   * @param board
   * @param hand
   * @return
   */
  public int findMinStep(String board, String hand) {
    final int[] balls = new int[26];
    // char count
    for (char chr : hand.toCharArray()) {
      balls[chr - 'A']++;
    }

    return findMinStep(board, balls);
  }

  int findMinStep(String board, final int[] balls) {
    board = removeContinuous(board);
    if (board.isEmpty()) {
      return 0;
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0, j = 0; j <= board.length(); j++) {
      if (j < board.length() && board.charAt(i) == board.charAt(j)) continue;
      final int need = 3 - (j - i);
      if (balls[board.charAt(i) - 'A'] >= need) {
        balls[board.charAt(i) - 'A'] -= need;
        int curRemain = findMinStep(board.substring(0, i) + board.substring(j), balls);
        if (curRemain != -1 && need + curRemain < res) {
          res = need + curRemain;
        }
        balls[board.charAt(i) - 'A'] += need;
      } // end if need
      i = j;
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  static String removeContinuous(String board) {
    for (int i = 0, j = 0; j <= board.length(); j++) {
      if (j < board.length() && board.charAt(i) == board.charAt(j)) {
        continue;
      }
      if (j - i >= 3) {
        return removeContinuous(board.substring(0, i) + board.substring(j));
      }
      i = j;
    }
    return board;
  }

}
