package interviews.uber._208_Implement_Trie_Prefix_Tree;


public final class Trie {
  private static final int N = 26, BASE = 'a';
  private final Node root = new Node();

  /**
   * Initialize your data structure here.
   */
  public Trie() {

  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    insert(root, word, 0);
  }

  private void insert(final Node root, final String word, final int start) {
    if (start == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(start);
    if (root.next[chr - BASE] == null) {
      root.next[chr - BASE] = new Node();
    }
    insert(root.next[chr - BASE], word, start + 1);
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    return search(root, word, 0);
  }

  private boolean search(final Node root, final String word, int start) {
    if (root == null) {
      return false;
    }
    if (start == word.length()) {
      return root.word != null;
    }

    final char chr = word.charAt(start);
    return search(root.next[chr - BASE], word, start + 1);
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    return startsWith(root, prefix, 0);
  }

  private boolean startsWith(final Node root, final String prefix, int start) {
    if (root == null) {
      return false;
    }
    if (start == prefix.length()) {
      return true;
    }

    // normal search
    final char chr = prefix.charAt(start);
    return startsWith(root.next[chr - BASE], prefix, start + 1);
  }


  private static final class Node {
    private String word;
    private final Node[] next = new Node[N];
  }
}
