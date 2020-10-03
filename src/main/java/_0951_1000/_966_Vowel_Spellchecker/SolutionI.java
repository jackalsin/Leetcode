package _0951_1000._966_Vowel_Spellchecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/2/2020
 */
public final class SolutionI implements Solution {

  public String[] spellchecker(String[] wordlist, String[] queries) {
    if (wordlist == null) {
      return new String[0];
    }
    final Set<String> wordSet = new HashSet<>();
    final Map<String, String> lowerToOriginal = new HashMap<>(),
        vowelToOriginal = new HashMap<>();
    for (final String word : wordlist) {
      final String lower = word.toLowerCase(),
          vowel = lower.replaceAll("[aeiou]", "a");
      wordSet.add(word);
      lowerToOriginal.putIfAbsent(lower, word);
      vowelToOriginal.putIfAbsent(vowel, word);
    }
    final List<String> result = new ArrayList<>();
    for (final String q : queries) {
      if (wordSet.contains(q)) {
        result.add(q);
        continue;
      }
      final String lowerQ = q.toLowerCase();
      if (lowerToOriginal.containsKey(lowerQ)) {
        result.add(lowerToOriginal.get(lowerQ));
        continue;
      }
      final String vowel = lowerQ.replaceAll("[aeiou]", "a");
      if (vowelToOriginal.containsKey(vowel)) {
        result.add(vowelToOriginal.get(vowel));
        continue;
      }
      result.add("");
    }
    return result.toArray(new String[0]);
  }
}
