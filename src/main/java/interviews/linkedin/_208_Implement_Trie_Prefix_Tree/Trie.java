package interviews.linkedin._208_Implement_Trie_Prefix_Tree;

public final class Trie {

  private final Node root = new Node();

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    insert(root, word, 0);
  }

  private void insert(final Node root, final String word, int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, i + 1);
  }


  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    return search(root, word, 0);
  }

  private boolean search(final Node root, final String word, final int i) {
    if (i == word.length()) {
      return root.word != null;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return false;
    }

    return search(root.next[chrIndex], word, i + 1);
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    return startsWith(root, prefix, 0);
  }

  private boolean startsWith(final Node root, final String word, final int i) {
    if (i == word.length()) {
      return true;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return false;
    }

    return startsWith(root.next[chrIndex], word, i + 1);
  }

  private static final class Node {

    private String word;
    private final Node[] next = new Node[26];

  }
}
