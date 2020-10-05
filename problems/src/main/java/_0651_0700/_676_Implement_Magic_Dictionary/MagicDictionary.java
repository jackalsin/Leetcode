package _0651_0700._676_Implement_Magic_Dictionary;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 12/30/2017.
 */
public final class MagicDictionary {
  private static final char A = 'a';
  private static final int N = 26;
  private final Node root;

  /**
   * Initialize your data structure here.
   */
  public MagicDictionary() {
    root = new Node('1');
  }

  /**
   * Build a dictionary through a list of words
   */
  public void buildDict(String[] dict) {
    for (String word : dict) {
      insert(root, word, 0);
    }
  }

  private void insert(final Node parent, final String word, int start) {
    if (start == word.length()) {
      parent.isWord = true;
    } else {
      final char chr = word.charAt(start);
      final int chrIndex = chr - A;
      if (parent.next[chrIndex] == null) {
        parent.next[chrIndex] = new Node(chr);
      }
      insert(parent.next[chrIndex], word, start + 1);
    }
  }

  /**
   * Returns if there is any word in the trie that equals to the given word after modifying
   * exactly one character
   */
  public boolean search(String word) {
    return search(root, word, 0, false);
  }

  private boolean search(final Node parent, final String word, int start, boolean isModified) {
    if (parent == null) {
      return false;
    } else if (start == word.length()) {
      return parent.isWord && isModified;
    } else {
      final char chr = word.charAt(start);
      final int chrIndex = chr - A;

      if (!isModified) {
        for (int i = 0; i < N; i++) {
          if ((i + A) == chr) {
            continue;
          }
          if (search(parent.next[i], word, start + 1, true)) {
            return true;
          }
        }
      }
      return search(parent.next[chrIndex], word, start + 1, isModified);
    }
  }


  private static final class Node {
    private final char chr;
    private final Node[] next;
    private boolean isWord = false;

    Node(char chr) {
      this.chr = chr;
      next = new Node[N];
    }

    @Override
    public String toString() {
      return "Node{" +
          "chr=" + chr +
          ", next=" + Arrays.toString(next) +
          ", isWord=" + isWord +
          '}';
    }
  }

}
