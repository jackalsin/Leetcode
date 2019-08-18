package interviews.linkedin._692_Top_K_Frequent_Words;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/17/2019
 */
public final class BucketSolution implements Solution {
  @Override
  public List<String> topKFrequent(String[] words, int k) {
    final LinkedList<String> result = new LinkedList<>();
    if (words == null) {
      return result;
    }
    final Map<String, Integer> wordCounts = getWordCount(words);

    final List<List<String>> buckets = new ArrayList<>();
    for (int i = 0; i <= words.length; ++i) {
      buckets.add(new ArrayList<>());
    }

    for (final Map.Entry<String, Integer> e : wordCounts.entrySet()) {
      final String word = e.getKey();
      final int count = e.getValue();
      buckets.get(count).add(word);
    }

    out:
    for (int count = words.length; count >= 0; --count) {
      final List<String> wordList = buckets.get(count);
      Collections.sort(wordList);
      for (final String w : wordList) {
        if (result.size() == k) {
          break out;
        }
        result.add(w);
      }
    }
    return result;
  }

  private static Map<String, Integer> getWordCount(final String[] words) {
    final Map<String, Integer> wordCounts = new HashMap<>();
    for (final String word : words) {
      wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }
    return wordCounts;
  }
}
