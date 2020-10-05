package _0851_0900._884_Uncommon_Words_from_Two_Sentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/16/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String[] uncommonFromSentences(String A, String B) {
    final Map<String, Integer> aWordFreq = getWordFreq(A),
        bWordFreq = getWordFreq(B);
    final List<String> result = new ArrayList<>();
    updateUncommon(result, aWordFreq, bWordFreq);
    updateUncommon(result, bWordFreq, aWordFreq);
    return result.toArray(new String[0]);
  }

  private static void updateUncommon(final List<String> result,
                                     final Map<String, Integer> aMap,
                                     final Map<String, Integer> bMap) {
    for (final var e : aMap.entrySet()) {
      final String word = e.getKey();
      final int count = e.getValue();
      if (count == 1 && !bMap.containsKey(word)) {
        result.add(word);
      }
    }
  }

  private static Map<String, Integer> getWordFreq(final String s) {
    final Map<String, Integer> result = new HashMap<>();
    final String[] items = s.split(" ");
    for (final String c : items) {
      result.put(c, result.getOrDefault(c, 0) + 1);
    }
    return result;
  }
}
