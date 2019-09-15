package _1151_1200._1189_Maximum_Number_of_Balloons;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/14/2019
 */
public final class SolutionI implements Solution {
  private static final String BALLOON = "balloon";

  public int maxNumberOfBalloons(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }
    final Map<Character, Integer> charCount = new HashMap<>();
    for (final char chr : text.toCharArray()) {
      charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
    }
    int res = Integer.MAX_VALUE;
    for (char chr : BALLOON.toCharArray()) {
      if (chr == 'l' || chr == 'o') {
        res = Math.min(res, charCount.getOrDefault(chr, 0) / 2);
      } else {
        res = Math.min(res, charCount.getOrDefault(chr, 0));
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }
}
