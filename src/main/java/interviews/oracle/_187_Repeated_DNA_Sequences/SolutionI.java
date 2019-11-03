package interviews.oracle._187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 11/2/2019
 */
public final class SolutionI implements Solution {
  private static final Map<Character, Integer> MAP = new HashMap<Character, Integer>() {{
    put('A', 0);
    put('C', 1);
    put('T', 2);
    put('G', 3);
  }};
  private static final Map<Integer, Character> REVERSE = new HashMap<Integer, Character>() {{
    put(0, 'A');
    put(1, 'C');
    put(2, 'T');
    put(3, 'G');
  }};

  private static final int N = 10, TEMPLATE = 0b1111_1111_1111_1111_1111;

  public List<String> findRepeatedDnaSequences(String s) {
    final Set<String> result = new HashSet<>();
    if (s == null || s.length() < 10) {
      return new ArrayList<>(result);
    }
    final char[] chars = s.toCharArray();
    int curString = 0;
    for (int i = 0; i < N; ++i) {
      curString = (curString << 2) | MAP.get(chars[i]);
    }
    final Set<Integer> visited = new HashSet<>();
    visited.add(curString);
    for (int i = 10; i < chars.length; ++i) {
      curString = ((curString << 2) & TEMPLATE) | MAP.get(chars[i]);
      if (visited.contains(curString)) {
        result.add(deserialize(curString));
      }
      visited.add(curString);
    }
    return new ArrayList<>(result);
  }

  static String deserialize(final int curString) {
    final StringBuilder sb = new StringBuilder();
    for (int i = N - 1; i >= 0; i--) {
      int curDigit = (curString >> (2 * i)) & 0b11;
      sb.append(REVERSE.get(curDigit));
    }
    return sb.toString();
  }
}
