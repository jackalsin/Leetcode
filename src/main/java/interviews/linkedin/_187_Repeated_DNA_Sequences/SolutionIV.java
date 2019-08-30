package interviews.linkedin._187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/29/2019
 */
public final class SolutionIV implements Solution {
  private static final Map<Character, Integer> MAP = new HashMap<Character, Integer>() {{
    put('A', 0);
    put('C', 1);
    put('T', 2);
    put('G', 3);
  }};
  private static final Map<Integer, Character> REVERSE_MAP = new HashMap<Integer, Character>() {
    {
      put(0, 'A');
      put(1, 'C');
      put(2, 'T');
      put(3, 'G');
    }
  };

  private static final int MASK = 0xF_FFFF;

  public List<String> findRepeatedDnaSequences(String s) {
    final Set<String> result = new HashSet<>();
    if (s == null || s.length() <= 10) {
      return new ArrayList<>(result);
    }
    final char[] chars = s.toCharArray();
    final Set<Integer> visited = new HashSet<>();
    int cur = 0;
    for (int i = 0; i < 10; ++i) {
      cur = (cur << 2) | MAP.get(chars[i]);
    }
    visited.add(cur);
    for (int i = 10; i < chars.length; ++i) {
      cur = (cur << 2 | MAP.get(chars[i])) & MASK;
      if (visited.contains(cur)) {
        result.add(getString(cur));
      } else {
        visited.add(cur);
      }
    }
    return new ArrayList<>(result);
  }

  private static String getString(int cur) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      final int curVal = cur & 0x3;
      sb.append(REVERSE_MAP.get(curVal));
      cur >>= 2;
    }
    return sb.reverse().toString();
  }
}
