package _701_750._745_Prefix_and_Suffix_Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/29/2018.
 */
public class WordFilterTwoDimensionSolution implements WordFilter {
  private static final int N = 26, INVALID = 0;
  private static final char A = 'a';
  private final TrieNode root = new TrieNode((char) INVALID);

  public WordFilterTwoDimensionSolution(String[] words) {
    for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
      String word = words[i];
      insert(root, word, 0, i);
    }
  }

  private void insert(final TrieNode parent, final String word, final int startIndex, final int
      weight) {
    /* No need to compare, must be greater */
    parent.weight = weight;
    if (startIndex == word.length()) {
      return;
    }
    final char preChar = word.charAt(startIndex),
        suffixChar = word.charAt(word.length() - 1 - startIndex);
    if (parent.next[preChar - A][suffixChar - A] == null) {
      parent.next[preChar - A][suffixChar - A] = new TrieNode(preChar);
    }
    insert(parent.next[preChar - A][suffixChar - A], word, startIndex + 1, weight);
  }

  @Override
  public int f(String prefix, String suffix) {
    return search(root, prefix, suffix, 0);
  }

  private int search(final TrieNode parent, String prefix, String suffix, int startIndex) {
    int result = -1;
    if (parent == null) {
      return result;
    }
    if (prefix.length() > startIndex && suffix.length() > startIndex) {
      final char preChar = prefix.charAt(startIndex),
          suffixChar = suffix.charAt(suffix.length() - 1 - startIndex);
      int tmpRes = search(parent.next[preChar - A][suffixChar - A], prefix, suffix, startIndex + 1);
      if (tmpRes >= 0) {
        result = Math.max(tmpRes, result);
      }
    } else if (prefix.length() > startIndex) { // suffix.length <= startIndex;
      final List<TrieNode> candidateTrieNodes = new ArrayList<>();
      final char preChar = prefix.charAt(startIndex);
      for (int i = 0; i < N; i++) {
        if (parent.next[preChar - A][i] != null) {
          candidateTrieNodes.add(parent.next[preChar - A][i]);
        }
      }
      for (final TrieNode candidate : candidateTrieNodes) {
        result = Math.max(result, search(candidate, prefix, suffix, startIndex + 1));
      }
    } else if (suffix.length() > startIndex) { // prefix.length <= startIndex;
      final List<TrieNode> candidateTrieNodes = new ArrayList<>();
      final char suffixChar = suffix.charAt(suffix.length() - 1 - startIndex);
      for (int i = 0; i < N; i++) {
        if (parent.next[i][suffixChar - A] != null) {
          candidateTrieNodes.add(parent.next[i][suffixChar - A]);
        }
      }
      for (final TrieNode candidate : candidateTrieNodes) {
        result = Math.max(result, search(candidate, prefix, suffix, startIndex + 1));
      }
    } else {
      assert (suffix.length() <= startIndex && prefix.length() <= startIndex);
      result = Math.max(result, parent.weight);
    }
    return result;
  }

  private static final class TrieNode {
    private final char chr;
    private final TrieNode[][] next = new TrieNode[N][N];
    private int weight = INVALID;

    TrieNode(final char chr) {
      this.chr = chr;
    }
  }
}
