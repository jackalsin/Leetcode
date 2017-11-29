package _451_500._474_Ones_and_Zeroes;

/**
 * @author jacka
 * @version 1.0 on 11/27/2017.
 */
public class Solution {

  /**
   * The reason why we need iterate from right to left: https://discuss.leetcode
   * .com/topic/71438/c-dp-solution-with-comments
   */
  public int findMaxForm(String[] strs, int m, int n) {
    final int[][] board = new int[m + 1][n + 1];
    for (String str : strs) {
      int[] counts = getCount(str);

//      for (int zeroCount = counts[0]; zeroCount <= m; zeroCount++) {
//        for (int oneCount = counts[1]; oneCount <= n; oneCount++) {
//          board[zeroCount][oneCount] = Math.max(board[zeroCount][oneCount],
//              board[zeroCount - counts[0]][oneCount - counts[1]] + 1);
//        }
//      }

      // memo[i][j] = the max number of strings that can be formed with i 0's and j 1's
      // from the first few strings up to the current string s
      // Catch: have to go from bottom right to top left
      // Why? If a cell in the memo is updated(because s is selected),
      // we should be adding 1 to memo[i][j] from the previous iteration (when we were not
      // considering s)
      // If we go from top left to bottom right, we would be using results from this iteration =>
      // overcounting
      for (int zeroCount = m; zeroCount >= counts[0]; zeroCount--) {
        for (int oneCount = n; oneCount >= counts[1]; oneCount--) {
          board[zeroCount][oneCount] = Math.max(board[zeroCount][oneCount],
              board[zeroCount - counts[0]][oneCount - counts[1]] + 1);
        }
      }
    }
    return board[m][n];
  }

  private static int[] getCount(String s) {
    int zeroCount = 0, oneCount = 0;
    for (char chr : s.toCharArray()) {
      if (chr == '1') {
        oneCount++;
      } else {
        zeroCount++;
      }
    }
    return new int[] {zeroCount, oneCount};
  }

}
