package _1251_1300._1268_Search_Suggestions_System;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 12/23/2019
 */
public final class TrieSolution implements Solution {
  private final TrieNode root = new TrieNode();
  private static final int N = 26;

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    for (final String product : products) {
      add(root, product, 0);
    }
    final List<List<String>> result = new ArrayList<>();
    search(result, root, searchWord, 0);
    return result;
  }

  private static void search(final List<List<String>> result, final TrieNode root, final String word, final int i) {
    if (i != 0) {
      if (root == null) {
        result.add(new ArrayList<>());
      } else {
        result.add(new ArrayList<>(root.children));
      }
    }
    if (i == word.length()) {
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    search(result, root == null ? null : root.next[chrIndex], word, i + 1);
  }

  private static void add(final TrieNode root, final String word, final int i) {
    root.children.add(word);
    if (root.children.size() > 3) {
      root.children.remove(root.children.last());
    }
    if (i == word.length()) {
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new TrieNode();
    }
    add(root.next[chrIndex], word, i + 1);
  }

  private static final class TrieNode {
    private final TrieNode[] next = new TrieNode[N];
    private TreeSet<String> children = new TreeSet<>();
  }
}
