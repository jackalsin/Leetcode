package google.distinct_letters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/5/2021
 */
public class SolutionI implements Solution {
  @Override
  public int distinctLetterPair(String s) {
    if (s == null || s.length() <= 1) return 0;
    final char[] chars = s.toCharArray();
    final Map<Character, Integer> left = new HashMap<>() {{
      put(s.charAt(0), 1);
    }}, right = new HashMap<>();
    final Set<Long> set = new HashSet<>();
    // init right
    for (int i = 1; i < chars.length; ++i) {
      right.put(chars[i], right.getOrDefault(chars[i], 0) + 1);
    }
    set.add(key(left.size(), right.size()));
    for (int i = 1; i < chars.length - 1; ++i) {
      left.put(chars[i], left.getOrDefault(chars[i], 0) + 1);
      final int prevCount = right.get(chars[i]);
      if (prevCount == 1) right.remove(chars[i]);
      else right.put(chars[i], prevCount - 1);
//      System.out.println(left.size() + "\t" + right.size());
      set.add(key(left.size(), right.size()));
    }
    return set.size();
  }

  private static long key(final long left, final long right) {
    if (right < left) return key(right, left);
    return left << 32 | right;
  }
}
