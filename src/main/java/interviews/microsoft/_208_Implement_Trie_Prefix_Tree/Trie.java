package interviews.microsoft._208_Implement_Trie_Prefix_Tree;

public final class Trie {
  private static final int N = 26;
  private static final char BASE = 'a';
  private final Node root;

  /**
   * Initialize your data structure here.
   */
  public Trie() {
    root = new Node();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    insert(root, word, 0);
  }

  private void insert(Node root, String word, int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final int chrIndex = word.charAt(i) - BASE;
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

  private boolean search(Node root, String word, int i) {
    assert root != null;
    if (i == word.length()) {
      return root.word != null;
    }

    final int chrIndex = word.charAt(i) - BASE;
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

  private boolean startsWith(Node root, String prefix, int i) {
    if (i == prefix.length()) {
      return root != null;
    }

    if (root == null) {
      return false;
    }

    final int chrIndex = prefix.charAt(i) - BASE;
    return startsWith(root.next[chrIndex], prefix, i + 1);
  }

  private static final class Node {
    private String word;
    private final Node[] next = new Node[26];
  }
}
