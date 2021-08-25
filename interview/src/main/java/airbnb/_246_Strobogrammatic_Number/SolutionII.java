package airbnb._246_Strobogrammatic_Number;

import java.util.Map;

/**
 * @author zhixi
 * @version 1.0 on 8/24/2021
 */
public final class SolutionII implements Solution {
  private static final Map<Character, Character> MAP = Map.of(
      '0', '0',
      '1', '1',
      '9', '6',
      '6', '9',
      '8', '8'
  );

  public boolean isStrobogrammatic(String num) {
    if (num == null || num.isEmpty()) return false;
    final char[] chars = num.toCharArray();
    for (int i = 0, j = chars.length - 1; i <= j; i++, --j) {
      if (!MAP.containsKey(chars[i]) || MAP.get(chars[i]) != chars[j]) return false;
    }
    return true;
  }
}
