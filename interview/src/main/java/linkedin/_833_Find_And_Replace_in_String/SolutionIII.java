package linkedin._833_Find_And_Replace_in_String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    if (S == null || indexes == null || sources == null || targets == null) {
      return S;
    }
    final Map<Integer, Integer> reverseIndex = new HashMap<>();
    for (int i = 0; i < indexes.length; ++i) {
      if (S.startsWith(sources[i], indexes[i])) {
        reverseIndex.put(indexes[i], i);
      }
    } // end or for loop
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); ) {
      if (reverseIndex.containsKey(i)) {
        final int realIndex = reverseIndex.get(i);
        sb.append(targets[realIndex]);
        i += sources[realIndex].length();
      } else {
        sb.append(S.charAt(i++));
      }
    }
    return sb.toString();
  }
}
