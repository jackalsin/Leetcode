package linkedin._187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionI implements Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    final Map<Integer, Integer> counts = new HashMap<>();
    final List<String> result = new ArrayList<>();
    final int[] map = new int[128];
    map['A'] = 0;
    map['C'] = 1;
    map['G'] = 2;
    map['T'] = 3;
    for (int start = 0; start <= s.length() - 10; start++) {
      int cur = 0;
      for (int i = 0; i < 10; i++) {
        cur <<= 2;
        cur |= map[s.charAt(start + i)];
      }
      int curCount = counts.getOrDefault(cur, 0);
      if (curCount == 1) {
        result.add(s.substring(start, start + 10));
      }
      counts.put(cur, curCount + 1);
    }
    return result;
  }
}
