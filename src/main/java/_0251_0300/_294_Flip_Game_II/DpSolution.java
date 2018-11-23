package _0251_0300._294_Flip_Game_II;

import java.util.*;

/**
 * This is using dp.
 *
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
public class DpSolution implements Solution {

  @Override
  public boolean canWin(String s) {
    Deque<Integer> addCountsStack = new ArrayDeque<>();
    int count = 0, maxAddCount = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char chr = chars[i];
      if (chr == '+') {
        ++count;
      }
      if (chr == '-' || (i == chars.length - 1)){
        if (count >= 2) {
          addCountsStack.add(count);
          maxAddCount = Math.max(count, maxAddCount);
        }
        count = 0;
      }
    }

    int[] dp = getDp(maxAddCount);
    int gameStatus = 0;
    while (!addCountsStack.isEmpty()) {
      gameStatus ^= dp[addCountsStack.remove()];
    }
    return gameStatus != 0;
  }

  static int[] getDp(final int maxAddCount) {
    final int[] result = new int[maxAddCount + 1];
    for(int i = 2; i < result.length; ++i) {
      Set<Integer> gameStatus = new HashSet<>();
      for (int first = 0; first + first + 2 <= i; ++first) {
        gameStatus.add(result[first] ^ result[i - first - 2]);
      }
      result[i] = firstMissingValue(gameStatus);
    }
    return result;
  }

  private static int firstMissingValue(Collection<Integer> gameStatus) {
    for (int i = 0; i < gameStatus.size(); ++i) {
      if (!gameStatus.contains(i)) {
        return i;
      }
    }
    return gameStatus.size();
  }
}
