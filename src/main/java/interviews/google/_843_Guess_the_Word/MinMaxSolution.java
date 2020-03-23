package interviews.google._843_Guess_the_Word;

import utils._843_Guess_the_Word.Master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/22/2020
 */
public final class MinMaxSolution implements Solution {
  @Override
  public void findSecretWord(String[] wordlist, Master master) {
    List<String> words = new ArrayList<>(Arrays.asList(wordlist));
    for (int count = 0, match = 0; match < 6 && count < 10; count++) {
      final Map<String, Integer> zeroCountMap = getZeroMatch(words);
      final Map.Entry<String, Integer> minEntry = getMin(zeroCountMap);
//      System.out.println(zeroCountMap);
      match = master.guess(minEntry.getKey());
      final List<String> nextWords = new ArrayList<>();
      for (final String word : words) {
        if (match == match(word, minEntry.getKey())) {
          nextWords.add(word);
        }
      }
      words = nextWords;
    }
  }

  private static Map.Entry<String, Integer> getMin(final Map<String, Integer> zeroCountMap) {
    Map.Entry<String, Integer> min = null;
    for (final Map.Entry<String, Integer> e : zeroCountMap.entrySet()) {
      if (min == null) {
        min = e;
      } else if (min.getValue() > e.getValue()) {
        min = e;
      }
    }
    return min;
  }

  private static Map<String, Integer> getZeroMatch(final List<String> words) {
    final Map<String, Integer> map = new HashMap<>();
    for (final String word1 : words) {
      map.put(word1, 0);
      for (final String word2 : words) {
        if (match(word1, word2) == 0) {
          map.put(word1, map.get(word1) + 1);
        }
      }
    }
    return map;
  }

  private static int match(final String word1, final String word2) {
    int count = 0;
    for (int i = 0; i < word1.length(); ++i) {
      if (word1.charAt(i) == word2.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}
