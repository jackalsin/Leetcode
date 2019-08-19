package interviews.linkedin._833_Find_And_Replace_in_String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class SolutionII implements Solution {
  @Override
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    if (S == null || indexes == null || sources == null || targets == null) {
      return S;
    }
    final Map<Integer, Integer> reverseIndex = getReverseIndex(indexes);
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); ++i) {
      if (reverseIndex.containsKey(i)) {
        final int realIndex = reverseIndex.get(i);
        if (S.startsWith(sources[realIndex], i)) {
          sb.append(targets[realIndex]);
          i += (sources[realIndex].length() - 1);
        } else {
          sb.append(S.charAt(i));
        }
      } else {
        sb.append(S.charAt(i));
      }
    }
    return sb.toString();
  }

  private static Map<Integer, Integer> getReverseIndex(final int[] indexes) {
    final Map<Integer, Integer> res = new HashMap<>();
    for (int i = 0; i < indexes.length; ++i) {
      res.put(indexes[i], i);
    }
    return res;
  }
}
