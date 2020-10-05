package twoSigma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class StringChains {
  private static final int N = 26;
  private int result = 0;
  private final Map<String, Integer> cache = new HashMap<>();
  private final Node root = new Node();

  public int get(final List<String> words) {
    if (words == null || words.size() == 0) {
      return 0;
    }
    words.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
    for (final String word : words) {
      insert(root, word, 0);
    }

    for (final String word : words) {
      dfs(word);
    }
    return result;
  }

  private int dfs(final String word) {
    if (cache.containsKey(word)) {
      return cache.get(word);
    }
    if (word.length() == 0) {
      return 1;
    }
    int max = 0;
    for (int i = 0; i < word.length(); i++) {
      final String nextString = word.substring(0, i) + word.substring(i + 1);
      if (search(root, nextString, 0)) {
        int curMax = dfs(nextString);
        max = Math.max(max, curMax);
      }
    }
    cache.put(word, max + 1);
    result = Math.max(result, max + 1);
    return max + 1;
  }

  private boolean search(final Node root, final String word, final int i) {
    if (i == word.length()) {
      return root.isWord;
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return false;
    }
    return search(root.next[chrIndex], word, i + 1);
  }

  private void insert(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.isWord = true;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, i + 1);
  }

  private static final class Node {
    private boolean isWord = false;
    private final Node[] next = new Node[N];
  }
}
