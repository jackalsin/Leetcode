package _0651_0700._681_Next_Closest_Time;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 12/30/2017.
 */
public class Solution {

  public String nextClosestTime(String time) {
    final Set<Integer> occurred = new HashSet<>();
    for (char chr : time.toCharArray()) {
      if (chr != ':') {
        occurred.add(chr - '0');
      }
    }
    final int hr = Integer.valueOf(time.split(":")[0]), min = Integer.parseInt(time.split(":")[1]);
    final List<Integer> candidates = new ArrayList<>(occurred);
    Collections.sort(candidates);
    int nextMin = getNextPermutation(candidates, min, 60);
    int nextHour = hr;
    if (nextMin < min) {
      nextHour = getNextPermutation(candidates, hr, 24);
    }
    String nextHourStr = nextHour < 10 ? ("0" + nextHour) : "" + nextHour;
    String nextMinStr = nextMin < 10 ? ("0" + nextMin) : "" + nextMin;
    return nextHourStr + ":" + nextMinStr;
  }

  /**
   * @param limit 60 or 24
   */
  int getNextPermutation(final List<Integer> candidates, final int min, final int limit) {
    int tens = min / 10, ones = min % 10;
    int onesIndex = candidates.indexOf(ones);
    int possibleAns = -1;
    if (onesIndex != candidates.size() - 1) {
      possibleAns = tens * 10 + candidates.get(onesIndex + 1);
    } else {
      int tensIndex = candidates.indexOf(tens);
      if (tensIndex != candidates.size() - 1) {
        possibleAns = candidates.get(tensIndex + 1) * 10 + candidates.get(0);
      } else {
        return candidates.get(0) * 10 + candidates.get(0);
      }
    }
    if (possibleAns >= limit) { // 超过limit了，类似于进位
      return candidates.get(0) * 10 + candidates.get(0);
    } else {
      return possibleAns;
    }
  }
}
