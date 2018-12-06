package _0901_0950._936_Stamping_The_Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public int[] movesToStamp(String stamp, String target) {
    final char[] aim = new char[target.length()], cur = target.toCharArray();
    Arrays.fill(aim, '*');
    final List<Integer> result = new ArrayList<>();
    while (!Arrays.equals(aim, cur)) {
      int position = replace(cur, stamp);
      if (position < 0) return new int[0]; // impossible to traverse into "***...***"
      result.add(position);
    }

    final int[] ret = new int[result.size()];

    for (int i = result.size() - 1; i >= 0; i--) {
      ret[i] = result.get(result.size() - i - 1);
    }

    return ret;
  }

  /**
   * @param target
   * @param stamp
   * @return -1 when not found any pattern can be matched; otherwise, return the start position
   */
  private int replace(final char[] target, String stamp) {

    for (int start = 0; start <= target.length - stamp.length(); start++) {
      int stampIndex = 0;
      boolean hasCharMatch = false;
      for (int targetIndex = 0; targetIndex < target.length && stampIndex < stamp.length(); ) {
        final char targetChar = target[start + targetIndex];
        if (stamp.charAt(stampIndex) != targetChar && targetChar != '*') {
          break;
        }
        hasCharMatch |= (targetChar != '*');
        targetIndex++;
        stampIndex++;
      }

      if (stampIndex == stamp.length() && hasCharMatch) {
        Arrays.fill(target, start, start + stamp.length(), '*');
        return start;
      }
    }

    return -1;
  }
}
