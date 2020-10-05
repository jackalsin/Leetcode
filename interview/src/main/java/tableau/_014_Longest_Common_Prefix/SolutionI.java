package tableau._014_Longest_Common_Prefix;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {
  private final Node root = new Node();

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    final int size = strs.length;
    for (int i = 0; i < size - 1; ++i) {
      add(root, strs[i], 0);
    }

    return search(root, strs[strs.length - 1], 0, size - 1);
  }

  private String search(final Node root, final String word, final int i, final int count) {
    if (root == null) {
      return word.substring(0, i - 1);
    }
    if (root.count != count) {
      return word.substring(0, i - 1);
    }
    if (i == word.length()) {
      return word;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    return search(root.next[chrIndex], word, i + 1, count);
  }

  private void add(final Node root, final String word, final int i) {
    root.count++;
    if (i == word.length()) {
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    add(root.next[chrIndex], word, i + 1);
  }

  private static final class Node {
    private int count;
    private final Node[] next = new Node[26];
  }
}
