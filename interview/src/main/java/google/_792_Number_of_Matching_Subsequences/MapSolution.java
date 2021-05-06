package google._792_Number_of_Matching_Subsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/5/2021
 */
public final class MapSolution implements Solution {
  @Override
  public int numMatchingSubseq(String S, String[] words) {
    if (S == null || S.isEmpty()) return 0;
    final Map<Character, List<Pair>> charToWords = new HashMap<>();
    for (final String word : words) {
      charToWords.computeIfAbsent(word.charAt(0), k -> new ArrayList<>()).add(new Pair(word));
    }
    final char[] s = S.toCharArray();
    int count = 0;
    for (int i = 0; i < s.length; ++i) {
      final char c = s[i];
      final List<Pair> cur = (charToWords.getOrDefault(c, Collections.emptyList()));
      charToWords.put(c, new ArrayList<>());
      for (final Pair p : cur) {
        final int charIndex = p.ptr;
        if (charIndex == p.word.length()) {
          count++;
        } else {
          charToWords.computeIfAbsent(p.word.charAt(charIndex), k -> new ArrayList<>()).add(p);
          p.ptr++;
        }
      }
    }
    return count;
  }

  private static final class Pair {
    private final String word;
    private int ptr = 1;

    private Pair(String word) {
      this.word = word;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "word='" + word + '\'' +
          ", ptr=" + ptr +
          '}';
    }
  }
}
