package _0651_0700._692_Top_K_Frequent_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/1/2019
 */
public final class BucketSolution implements Solution {
  private static final int N = 26;

  public List<String> topKFrequent(String[] words, int k) {
    if (words == null || words.length == 0) {
      return new ArrayList<>();
    }
    final Map<String, Integer> wordCount = getWordCount(words);
    final List<String> result = new ArrayList<>();
    final Node[] buckets =
        new Node[words.length + 1];
    for (final Map.Entry<String, Integer> e : wordCount.entrySet()) {
      final String word = e.getKey();
      final int count = e.getValue();
      if (buckets[count] == null) {
        buckets[count] = new Node();
      }
      addWord(buckets[count], word, 0);
    }
    for (int i = words.length; i >= 0; --i) {
      if (buckets[i] == null) continue;
      get(buckets[i], result, k);
      if (result.size() == k) {
        break;
      }
    }
    return result;
  }

  private static void addWord(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    addWord(root.next[chrIndex], word, i + 1);
  }

  private static void get(final Node root, final List<String> result, final int k) {
    assert root != null;
    if (root.word != null) {
      result.add(root.word);
      if (result.size() == k) {
        return;
      }
    }

    for (int i = 0; i < N; ++i) {
      if (root.next[i] == null) continue;
      get(root.next[i], result, k);
      if (result.size() == k) {
        return;
      }
    }
  }

  private static Map<String, Integer> getWordCount(final String[] words) {
    final Map<String, Integer> result = new HashMap<>();
    for (final String word : words) {
      result.put(word, result.getOrDefault(word, 0) + 1);
    }
    return result;
  }

  private static final class Node {
    private String word;
    private final Node[] next = new Node[N];
  }
}
