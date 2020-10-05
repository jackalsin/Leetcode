package _0801_0850._833_Find_And_Replace_in_String;

import java.util.HashMap;
import java.util.Map;

public final class LeftToRightSolution implements Solution {

  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    final Map<Integer, Integer> matched = new HashMap<>();
    for (int i = 0; i < indexes.length; i++) {
      if (S.startsWith(sources[i], indexes[i])) {
        matched.put(indexes[i], i);
      }
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); ) {
      if (matched.containsKey(i)) {
        final String source = sources[matched.get(i)], target = targets[matched.get(i)];
        sb.append(target);
        i += source.length();
      } else {
        sb.append(S.charAt(i++));
      }
    }
    return sb.toString();
  }
}
