package google._833_Find_And_Replace_in_String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/29/2021
 */
public final class SolutionII implements Solution {
  public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
    if (s == null || s.isEmpty() || indexes == null || indexes.length == 0) return s;
    final Map<Integer, Integer> iToIndex = new HashMap<>();
    for (int i = 0; i < indexes.length; ++i) {
      iToIndex.put(indexes[i], i);
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ) {
      if (iToIndex.containsKey(i) && s.startsWith(sources[iToIndex.get(i)], i)) {
        final int indexI = iToIndex.get(i);
        final String target = targets[indexI],
            source = sources[indexI];
        sb.append(target);
        i += source.length();
      } else {
        sb.append(s.charAt(i));
        ++i;
      }
    }
    return sb.toString();
  }

}
