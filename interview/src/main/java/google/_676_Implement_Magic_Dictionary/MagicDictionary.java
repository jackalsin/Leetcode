package google._676_Implement_Magic_Dictionary;

import java.util.Arrays;

/**
 * Time Complexity:
 * build: O(N * W) for N words, W longest word length
 * search: O (26 ^ W)
 *
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public final class MagicDictionary {
  private static final char A = 'a';
  private static final int N = 26;
  private final Node root = new Node('1');

  /**
   * Initialize your data structure here.
   */
  public MagicDictionary() {

  }

  /**
   * Build a dictionary through a list of words
   */
  public void buildDict(String[] dict) {
    Arrays.stream(dict).forEach(word -> insert(word, 0, root));
  }


  void insert(final String word, int index, final Node parent) {
    if (index == word.length()) {
      parent.isWord = true;
      return;
    }
    final char chr = word.charAt(index);
    if (parent.next[chr - A] == null) {
      parent.next[chr - A] = new Node(chr);
    }

    insert(word, index + 1, parent.next[chr - A]);
  }


  /**
   * Returns if there is any word in the trie that equals to the given word after modifying
   * exactly one character
   */
  public boolean search(String word) {
    return search(word, 0, root, false);
  }

  private boolean search(final String word, int startIndex, final Node parent, boolean isModified) {
    if (parent == null) {
      return false;
    }
    if (startIndex == word.length()) {
      return parent.isWord && isModified;
    }
    final char chr = word.charAt(startIndex);
    if (isModified) {
      return search(word, startIndex + 1, parent.next[chr - A], isModified);
    }
    for (char c = A; c <= 'z'; c++) {
      if (c != chr) {
        if (search(word, startIndex + 1, parent.next[c - A], true)) {
          return true;
        }
      } else {
        if (search(word, startIndex + 1, parent.next[c - A], false)) {
          return true;
        }
      }
    }
    return false;
  }


  private static final class Node {
    private final char chr;
    private final Node[] next = new Node[N];
    private boolean isWord = false;

    public Node(char chr) {
      this.chr = chr;
    }
  }
}
