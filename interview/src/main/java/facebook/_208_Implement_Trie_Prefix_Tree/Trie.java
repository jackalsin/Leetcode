package facebook._208_Implement_Trie_Prefix_Tree;

public class Trie {
  private final TrieNode root = new TrieNode();
  private static final char BASE = 'a';

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    insert(root, word, 0);
  }

  private void insert(TrieNode root, String word, int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final int chrIndex = word.charAt(i) - BASE;

    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new TrieNode();
    }

    insert(root.next[chrIndex], word, i + 1);
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    return search(root, word, 0);
  }

  private boolean search(TrieNode root, String word, int i) {
    if (root == null) {
      return false;
    }

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

  private boolean startsWith(TrieNode root, String prefix, int i) {
    if (i == prefix.length()) {
      return true;
    }

    final int chrIndex = prefix.charAt(i) - BASE;

    if (root.next[chrIndex] == null) {
      return false;
    }

    return startsWith(root.next[chrIndex], prefix, i + 1);
  }

  private static final class TrieNode {
    private String word;
    private final TrieNode[] next = new TrieNode[26];
  }
}
