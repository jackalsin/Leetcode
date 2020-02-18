package interviews.tableau._488_Zuma_Game;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {
  private static final char A = 'A';

  public int findMinStep(String board, String hand) {
    final int[] balls = new int[26];
    for (char chr : hand.toCharArray()) {
      balls[chr - A]++;
    }
    return findMinStep(board, balls);
  }

  private static int findMinStep(String board, final int[] balls) {
    if (board.isEmpty()) {
      return 0;
    }
    int res = Integer.MAX_VALUE;
    // pick one to eliminate
    for (int i = 0; i < board.length(); ++i) {
      final char chr = board.charAt(i);
      final int start = i;
      while (i + 1 < board.length() && board.charAt(i + 1) == chr) {
        i++;
      }
      final int needed = Math.max(0, 3 - (i - start + 1));
      if (balls[chr - A] >= needed) {
        balls[chr - A] -= needed;
        final String nextString = board.substring(0, start) + board.substring(i + 1);
        final int remain = findMinStep(nextString, balls);
        if (remain != -1) {
          res = Math.min(res, remain + needed);
        }
        balls[chr - A] += needed;
      }
    } // end of for loop
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  static String removeContinuously(final String board) {
    for (int i = 0; i < board.length(); ++i) {
      final char chr = board.charAt(i);
      final int start = i;
      while ((i + 1) < board.length() && board.charAt(i + 1) == chr) {
        ++i;
      }
      if (i - start + 1 >= 3) { // we have dup
        return removeContinuously(board.substring(0, start) + board.substring(i + 1));
      }
    }
    return board;
  }
}
