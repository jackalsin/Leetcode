package google._833_Find_And_Replace_in_String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
public final class SolutionIII implements Solution {
  @Override
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    if (S == null || S.isEmpty() || indexes == null || indexes.length == 0) return S;
    final Map<Integer, Integer> iToIndex = new HashMap<>();
    for (int i = 0; i < indexes.length; ++i) {
      iToIndex.put(indexes[i], i);
    }
    final StringBuilder sb = new StringBuilder();

    for (int i = 0; i < S.length(); ) {
      if (iToIndex.containsKey(i) && S.startsWith(sources[iToIndex.get(i)], i)) {
        final int sourceI = iToIndex.get(i);
        sb.append(targets[sourceI]);
        i += sources[sourceI].length();
      } else {
        sb.append(S.charAt(i));
        ++i;
      }
    }
    return sb.toString();
  }
}
