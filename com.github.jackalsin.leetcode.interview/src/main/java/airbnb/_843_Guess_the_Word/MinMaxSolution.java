package airbnb._843_Guess_the_Word;

import definition._843_Guess_the_Word.Master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
public final class MinMaxSolution implements Solution {
  private static final int N = 10, WORD_LEN = 6;

  public void findSecretWord(String[] wordlist, Master master) {
    List<String> words = Arrays.asList(wordlist);
    for (int i = 0, match = 0; match < WORD_LEN && i < N; i++) {
      final Map<String, Integer> zeroMatchCount = getZeroMatch(words);
      final String minStr = getMinCount(words, zeroMatchCount);

      match = master.guess(minStr);

      final List<String> nextWords = new ArrayList<>();
      for (String w : words) {
        if (match(w, minStr) == match) {
          nextWords.add(w);
        }
      }
      words = nextWords;
    }
  }

  private String getMinCount(final List<String> words, final Map<String, Integer> zeroMatchCount) {
    int minCount = Integer.MAX_VALUE;
    String res = null;

    for (String w : words) {
      final int count = zeroMatchCount.getOrDefault(w, 0);
      if (minCount > count) {
        minCount = count;
        res = w;
      }
    }

    return res;
  }

  private static Map<String, Integer> getZeroMatch(final List<String> words) {
    final Map<String, Integer> result = new HashMap<>();
    for (int i = 0; i < words.size(); i++) {
      for (int j = i + 1; j < words.size(); j++) {
        final String src = words.get(i), tgt = words.get(j);
        if (match(src, tgt) == 0) {
          result.put(src, result.getOrDefault(src, 0) + 1);
          result.put(tgt, result.getOrDefault(tgt, 0) + 1);
        }
      }
    }
    return result;
  }

  private static int match(final String src, final String tgt) {
    int count = 0;
    for (int i = 0; i < WORD_LEN; i++) {
      if (src.charAt(i) == tgt.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}
