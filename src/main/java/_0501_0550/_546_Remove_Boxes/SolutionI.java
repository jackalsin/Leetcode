package _0501_0550._546_Remove_Boxes;

/**
 * Reference: https://leetcode.com/problems/remove-boxes/discuss/101310/Java-top-down-and-bottom-up-DP-solutions
 *
 * @author jacka
 * @version 1.0 on 1/27/2020
 */
public final class SolutionI implements Solution {

  public int removeBoxes(int[] boxes) {
    if (boxes == null || boxes.length == 0) {
      return 0;
    }
    final int len = boxes.length;
    final int[][][] dp = new int[len][len][len];
    return removeBoxes(boxes, dp, 0, len - 1, 0);
  }

  private int removeBoxes(final int[] boxes, final int[][][] dp, int start, int end,
                          int alreadyContinues) {
    if (start > end) {
      return 0;
    }
//    System.out.println("start = " + start + ", end = " + end + ", already = " + alreadyContinues);
    if (dp[start][end][alreadyContinues] > 0) {
      return dp[start][end][alreadyContinues];
    }
    while (start + 1 <= end && boxes[start + 1] == boxes[start]) {
      alreadyContinues++;
      start++;
    }
    int res = (alreadyContinues + 1) * (alreadyContinues + 1)
        + removeBoxes(boxes, dp, start + 1, end, 0);

    for (int j = start + 1; j <= end; ++j) {
      if (boxes[j] == boxes[start]) {
        res = Math.max(res,
            removeBoxes(boxes, dp, start + 1, j - 1, 0)
                + removeBoxes(boxes, dp, j, end, alreadyContinues + 1)
        );
      }
    }

    dp[start][end][alreadyContinues] = res;
    return res;
  }

}
