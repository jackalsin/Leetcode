package _0401_0450._425_Word_Squares;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/13/2019
 */
public final class SolutionII implements Solution {
  private static final int N = 26;

  public List<List<String>> wordSquares(String[] words) {
    final List<List<String>> result = new ArrayList<>();
    if (words == null) {
      return result;
    }
    // create a trie
    final Trie root = new Trie();
    for (int i = 0; i < words.length; i++) {
      root.add(words[i], i);
    }
    // search
    for (String word : words) {
      final List<String> curSquare = new ArrayList<>();
      curSquare.add(word);
      dfs(result, curSquare, root);
    }
    return result;
  }

  private void dfs(final List<List<String>> result, final List<String> curPath, final Trie root) {
    final String initWord = curPath.get(0);
    final int len = initWord.length();
    if (curPath.size() == len) {
      result.add(new ArrayList<>(curPath));
      return;
    }

    final String prefix = getPrefix(curPath);
    final List<TrieNode> next = root.searchPrefix(prefix);
    for (TrieNode n : next) {
      curPath.add(n.word);
      dfs(result, curPath, root);
      curPath.remove(curPath.size() - 1);
    }
  }

  private static String getPrefix(final List<String> curPath) {
    final StringBuilder sb = new StringBuilder();
    final int size = curPath.size();
    for (String cur : curPath) {
      sb.append(cur.charAt(size));
    }
    return sb.toString();
  }

  private static final class Trie {
    private final TrieNode root = new TrieNode();

    private List<TrieNode> searchPrefix(String prefix) {
      final List<TrieNode> result = new ArrayList<>();
      search(result, root, prefix, 0);
      return result;
    }

    private void search(final List<TrieNode> result, final TrieNode root, final String prefix, final int i) {
      if (root == null) {
        return;
      }
      if (i == prefix.length()) {
        searchAllChildren(result, root);
        return;
      }

      final char chr = prefix.charAt(i);
      final int chrIndex = chr - 'a';
      if (root.next[chrIndex] == null) {
        return;
      }
      search(result, root.next[chrIndex], prefix, i + 1);
    }

    private void searchAllChildren(final List<TrieNode> result, final TrieNode root) {
      if (root == null) {
        return;
      }
      if (root.word != null) {
        result.add(root);
      }
      for (TrieNode c : root.next) {
        searchAllChildren(result, c);
      }
    }

    private void add(String word, int index) {
      add(root, word, index, 0);
    }

    private static void add(final TrieNode root, final String word, final int indexInWords, final int i) {
      if (i == word.length()) {
        root.word = word;
        return;
      }
      final char chr = word.charAt(i);
      final int chrIndex = chr - 'a';
      if (root.next[chrIndex] == null) {
        root.next[chrIndex] = new TrieNode();
      }
      add(root.next[chrIndex], word, indexInWords, i + 1);
    }
  }

  private static final class TrieNode {
    private String word;
    private final TrieNode[] next = new TrieNode[N];
  }
}
