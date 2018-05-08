package _701_750._720_Longest_Word_in_Dictionary;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  private final TrieNode root = new TrieNode();

  /**
   * Time Complexity: O( max(len(word) * word.length() , N * log N) )
   *
   * @param words
   * @return
   */
  public String longestWord(String[] words) {
    if (words == null || words.length == 0) {
      return "";
    }
    Arrays.sort(words, new Comparator<>() {
      @Override
      public int compare(String o1, String o2) {
        int cmp = Integer.compare(o1.length(), o2.length());
        if (cmp == 0) {
          return o1.compareTo(o2);
        }
        return cmp;
      }
    });
    int maxLen = -1;
    String result = "";
    for (int i = 0; i < words.length; i++) {
      if (i > 0 && words[i].equals(words[i - 1])) {
        continue;
      }
      String word = words[i];
      if (searchAndInsert(root, word, 0) && word.length() > maxLen) {
        maxLen = word.length();
        result = word;
      }
    }

    return result;
  }

  private boolean searchAndInsert(final TrieNode root, String word, int i) {
    assert word.length() != 0;
    final char chr = word.charAt(i);
    final int trieIndex = chr - 'a';

    // trying to append
    if (i == word.length() - 1) {
      assert root.next[trieIndex] == null;
      root.next[trieIndex] = new TrieNode();
      return true;
    }

    if (root.next[trieIndex] == null) {
      return false;
    }

    return searchAndInsert(root.next[trieIndex], word, i + 1);
  }

  private static final class TrieNode {
    private final TrieNode[] next = new TrieNode[26];
    private boolean isWord;
  }
}
