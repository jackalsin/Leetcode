package _0901_0950._948_Bag_of_Tokens;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/26/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int bagOfTokensScore(int[] tokens, int P) {
    final int n = tokens.length;
    Arrays.sort(tokens);
    int cur = 0, max = 0;
    for (int left = 0, right = n - 1; left <= right; ) {
      if (tokens[left] <= P) {
        cur++;
        P -= tokens[left];
        max = Math.max(cur, max);
        ++left;
      } else {
        if (cur > 0) {
          cur--;
          P += tokens[right--];
        } else {
          break;
        }
      }
    }
    return max;
  }
}
