package _0651_0700._678_Valid_Parenthesis_String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public final class DfsSolution implements Solution {
  private final Map<Long, Boolean> cache = new HashMap<>();

  public boolean checkValidString(String s) {
    return checkValidString(s, 0, 0);
  }

  private boolean checkValidString(final String s, final int i, final int leftCount) {
    if (i == s.length()) {
      return leftCount == 0;
    }
    final long key = getKey(i, leftCount);
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    final char chr = s.charAt(i);
    final boolean res;
    if (chr == '(') {
      res = checkValidString(s, i + 1, leftCount + 1);
    } else if (chr == ')') {
      if (leftCount == 0) {
        res = false;
      } else {
        res = checkValidString(s, i + 1, leftCount - 1);
      }
    } else {
      res = checkValidString(s, i + 1, leftCount)
          || checkValidString(s, i + 1, leftCount + 1)
          || checkValidString(s, i + 1, leftCount - 1);
    }
    cache.put(getKey(i, leftCount), res);
    return res;
  }

  private static long getKey(final long i, final int leftCount) {
    return (i << 32) | leftCount;
  }
}
