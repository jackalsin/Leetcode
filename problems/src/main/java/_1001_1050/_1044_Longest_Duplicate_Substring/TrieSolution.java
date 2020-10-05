package _1001_1050._1044_Longest_Duplicate_Substring;

/**
 * This is an TLE Solution
 *
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
@Deprecated
public final class TrieSolution implements Solution {
  private String maxString = "";
  private static final int N = 26;

  public String longestDupSubstring(String S) {
    final Node root = new Node();
//    final char[] chars = S.toCharArray();
    for (int start = 0; start < S.length(); start++) {
      addAndSearch(root, S, start, start);
    }
    return maxString;
  }

  private void addAndSearch(final Node root, final String word, final int start, final int i) {
    if (root.wordIndex != null) {
      final int curLen = root.wordIndex[1] - root.wordIndex[0];
      if (maxString.length() < curLen) {
        maxString = word.substring(root.wordIndex[0], root.wordIndex[1]);
      }
    }
    if (i == word.length()) {
      return;
    }
    root.wordIndex = new int[]{start, i};
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    addAndSearch(root.next[chrIndex], word, start, i + 1);
  }

  private static final class Node {
    private int[] wordIndex;
    private final Node[] next = new Node[N];
    ;
  }
}
