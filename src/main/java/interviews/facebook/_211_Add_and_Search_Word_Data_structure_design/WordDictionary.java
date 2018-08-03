package interviews.facebook._211_Add_and_Search_Word_Data_structure_design;

public class WordDictionary {
  private final TrieNode root = new TrieNode();

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    insert(root, word, 0);
  }

  private void insert(TrieNode root, String word, int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new TrieNode();
    }

    insert(root.next[chrIndex], word, i + 1);
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
   */
  public boolean search(String word) {
    return search(root, word, 0);
  }

  private boolean search(TrieNode root, String word, int wordIndex) {
    if (wordIndex == word.length()) {
      return root.word != null;
    }

    final char chr = word.charAt(wordIndex);
    if (chr == '.') { // find all
      for (int i = 0; i < 26; i++) {
        if (root.next[i] == null) continue;
        if (search(root.next[i], word, wordIndex + 1)) {
          return true;
        }
      }
      return false;
    } else {
      final int chrIndex = chr - 'a';
      if (root.next[chrIndex] == null) {
        return false;
      }

      return search(root.next[chrIndex], word, wordIndex + 1);
    }
  }

  private static final class TrieNode {
    private String word;
    private final TrieNode[] next = new TrieNode[26];
  }
}
