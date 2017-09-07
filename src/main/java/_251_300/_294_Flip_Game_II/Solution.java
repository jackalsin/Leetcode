package _251_300._294_Flip_Game_II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
public class Solution {
  public boolean canWin(String s) {
    Map<Integer, Integer> addCounts = new HashMap<>();
    int count = 0, maxCount = 0;
    for(char chr : s.toCharArray()) {
      if (chr == '+') {
        count++;
      } else {
        if (count > 1) {
          maxCount = Math.max(maxCount, count);
          addCounts.put(count, addCounts.getOrDefault(count, 0) + 1);
          count = 0;
        }
      }
    }
    if (s.length() != 0 && s.charAt(s.length() - 1) == '+') {
      maxCount = Math.max(maxCount, count);
      addCounts.put(count, addCounts.getOrDefault(count, 0) + 1);
    }
    if (maxCount <= 1) return false;
    final int[] dp = getDp(maxCount);

    // sum all with count, if odd, win;
    int weightSum = 0;
    for (Map.Entry<Integer, Integer> entry : addCounts.entrySet()) {
      final int key = entry.getKey();
      final int val = entry.getValue();
      weightSum += dp[key] * val;
    }
    return (weightSum & 1) == 1;
  }

  static int[] getDp(final int maxAddCount) {
    final int[] dp = new int[maxAddCount + 1];
    dp[2] = 1;
    for (int i = 3; i < dp.length; i++) {
      for (int startTrunc = 0; startTrunc + 2 + startTrunc <= i; ++startTrunc) {
        //  dp[startTrunc] + dp[2] + dp[i - startTrunc - 2] // if odd wind
        dp[i] |= ((dp[startTrunc] + dp[2] + dp[i - startTrunc - 2]) % 2/* == 0 ? 1 : 0*/);
      }
    }
    return dp;
  }
  public static void main(String[] args) {
    System.out.println("+++++++++".length());
  }
}
