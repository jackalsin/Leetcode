package _0401_0450._425_Word_Squares;

import java.util.ArrayList;
import java.util.List;

/**
 * https://discuss.leetcode.com/topic/63516/explained-my-java-solution-using-trie-126ms-16-16
 * Explanation. Check the graph provided.
 */
public final class SolutionI implements Solution {
  public List<List<String>> wordSquares(String[] words) {
    final Trie trie = new Trie(words);
    final List<List<String>> result = new ArrayList<>();

    List<String> curPath = new ArrayList<>();
    for (String word : words) {
      curPath.add(word);
      dfs(result, curPath, trie, word.length());
      curPath.remove(curPath.size() - 1);
    }

    return result;
  }

  private void dfs(final List<List<String>> result, final List<String> curPath, final Trie trie, int len) {
    if (len == curPath.size()) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    int index = curPath.size();
    final StringBuilder sb = new StringBuilder();
    for (String curPathChild : curPath) {
      sb.append(curPathChild.charAt(index));
    }

    final List<String> candidates = trie.findByPrefix(sb.toString());
    for (String candidate : candidates) {
      curPath.add(candidate);
      dfs(result, curPath, trie, len);
      curPath.remove(curPath.size() - 1);
    }
  }

  private static final class Trie {
    private final Node root;

    Trie(final String[] words) {
      root = new Node();
      for (String word : words) {
        insert(word, root, new StringBuilder());
      }
    }

    private void insert(String word, Node root, StringBuilder curPath) {
      int index = curPath.length();
      if (index == word.length()) {
        return;
      }
      char chr = word.charAt(index);
      curPath.append(chr);
      if (root.nodes[chr - 'a'] == null) {
        root.nodes[chr - 'a'] = new Node(curPath);
      }
      root.prefixWords.add(word);
      insert(word, root.nodes[chr - 'a'], curPath);
    }

    private List<String> findByPrefix(String prefix) {
      return findByPrefix(prefix, root, 0);
    }

    private List<String> findByPrefix(final String prefix, Node root, int index) {
      if (index == prefix.length()) {
        return root.prefixWords;
      }
      final char chr = prefix.charAt(index);
      if (root.nodes[chr - 'a'] == null) {
        return new ArrayList<>();
      }
      return findByPrefix(prefix, root.nodes[chr - 'a'], index + 1);

    }

    private static final class Node {
      private final StringBuilder prefix;
      private final List<String> prefixWords;
      private final Node[] nodes;

      private Node() {
        prefix = null;
        nodes = new Node[26];
        prefixWords = new ArrayList<>();
      }

      private Node(StringBuilder prefix) {
        this.prefix = new StringBuilder(prefix);
        this.nodes = new Node[26];
        prefixWords = new ArrayList<>();
      }
    }
  }

}
