package _0801_0850._843_Guess_the_Word;

import utils._843_Guess_the_Word.Master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MiniMaxSolution implements Solution {
  private static final int MAX_GUESS = 10;

  public void findSecretWord(String[] wordlist, Master master) {
    List<String> wordList = Arrays.asList(wordlist);
    for (int k = 0, match = 0; match < 6 && k < MAX_GUESS; k++) {
      final Map<String, Integer> zeroMatchCount = getZeroMatch(wordList);

      Pair<String, Integer> minPair = new Pair<>("", wordList.size());
      System.out.println(zeroMatchCount);
      // 找到最少zero match的
      // 因为大概率match会出现0（25/26）^6≈79%，那么我们始终选取zero match最少的word，
      // 那么一旦出现match = 0，我们能够只留下count个words，从而骚起来
      for (String word : wordList) {
        // mistake 1: NullPointerException
        final int curWordZeroMatch = zeroMatchCount.getOrDefault(word, 0);
        if (curWordZeroMatch < minPair.val) {
          minPair = new Pair<>(word, curWordZeroMatch);
        }
      }

      match = master.guess(minPair.key);
      final List<String> nextWordList = new ArrayList<>();
      for (String word : wordList) {
        if (match(word, minPair.key) == match) {
          nextWordList.add(word);
        }
      } // end of wordList

      wordList = nextWordList;
    }
  }

  private static Map<String, Integer> getZeroMatch(final List<String> wordList) {
    final Map<String, Integer> count = new HashMap<>();
    for (String word1 : wordList) {
      for (String word2 : wordList) {
        if (match(word1, word2) == 0) {
          count.put(word1, count.getOrDefault(word1, 0) + 1);
        }
      }
    }
    return count;
  }

  private static int match(final String word1, String word2) {
    int res = 0;
    for (int i = 0; i < word1.length(); i++) {
      if (word1.charAt(i) == word2.charAt(i)) {
        res++;
      }
    }
    return res;
  }

  private static final class Pair<K, V> {
    private final K key;
    private final V val;

    private Pair(K key, V val) {
      this.key = key;
      this.val = val;
    }
  }
}
