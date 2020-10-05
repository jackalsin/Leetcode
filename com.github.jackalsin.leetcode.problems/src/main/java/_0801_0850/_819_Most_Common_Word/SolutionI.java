package _0801_0850._819_Most_Common_Word;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String mostCommonWord(String paragraph, String[] banned) {
    final String[] words = paragraph.split("\\W+");
    final Map<String, Integer> wordCounts = new HashMap<>();
    final Set<String> banSet = getBanSet(banned);
    String maxCountWord = null;
    int max = 0;
    for (String word : words) {
      final String key = word.toLowerCase();
      if (banSet.contains(key)) continue;
      final int newCount = wordCounts.getOrDefault(key, 0) + 1;
      wordCounts.put(key, newCount);
      if (newCount > max) {
        maxCountWord = key;
        max = newCount;
      }
    }
    return maxCountWord;
  }

  private static Set<String> getBanSet(final String[] banned) {
    return new HashSet<>(Arrays.asList(banned));
  }
}
