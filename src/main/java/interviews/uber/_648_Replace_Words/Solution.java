package interviews.uber._648_Replace_Words;

import java.util.List;

public class Solution {
  private static final int N = 26, BASE = 'a';
  private final TrieNode root = new TrieNode();


  /**
   * Time Complexity:
   * O(Max(dict.length, sentence.length) * max_word_length_in_dict)
   *
   * @param dict
   * @param sentence
   * @return
   */
  public String replaceWords(List<String> dict, String sentence) {
    /*
     * Time complexity O(dict.length * max_word_length)
     */
    for (final String d : dict) {
      insert(root, d, 0);
    }

    final StringBuilder sb = new StringBuilder();
    /*
     * Time complexity O(sentence.length * max_word_length)
     */
    for (final String word : sentence.split(" ")) {
      final String replaceWord = search(root, word, 0);
      sb.append(" ").append(replaceWord);
    }

    return sb.substring(1);
  }

  /**
   * Return the shortest replaced word if found, otherwise, word itself.
   *
   * @param root
   * @param word
   * @param start
   * @return
   */
  private String search(TrieNode root, String word, int start) {
    if (root == null) {
      return word;
    }
    if (root.word != null) {
      return root.word;
    }
    if (start == word.length()) {
      return word;
    }
    final char chr = word.charAt(start);
    return search(root.next[chr - BASE], word, start + 1);
  }

  private void insert(final TrieNode root, final String word, final int start) {
    if (start == word.length()) {
      root.word = word;
      return;
    }

    if (root.next[word.charAt(start) - BASE] == null) {
      root.next[word.charAt(start) - BASE] = new TrieNode();
    }
    insert(root.next[word.charAt(start) - BASE], word, start + 1);
  }


  private static final class TrieNode {
    /* possible convert to boolean */
    private String word;
    private final TrieNode[] next = new TrieNode[N];

  }
}
