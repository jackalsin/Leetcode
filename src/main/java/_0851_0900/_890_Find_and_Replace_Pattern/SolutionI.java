package _0851_0900._890_Find_and_Replace_Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/20/2019
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    final List<String> result = new ArrayList<>();
    if (words == null || pattern == null) {
      return result;
    }
    final int[] patternToMatch = getNormalizedString(pattern);
    for (String word : words) {
      if (word.length() != pattern.length()) continue;
      final int[] target = getNormalizedString(word);
      if (Arrays.equals(patternToMatch, target)) {
        result.add(word);
      }
    }
    return result;
  }

  private static int[] getNormalizedString(final String pattern) {
    final Map<Character, Integer> map = new HashMap<>();
    final int[] result = new int[pattern.length()];
    for (int i = 0; i < pattern.length(); ++i) {
      final char chr = pattern.charAt(i);
      if (!map.containsKey(chr)) {
        map.put(chr, map.size());
      }
      result[i] = map.get(chr);
    }
    return result;
  }
}
