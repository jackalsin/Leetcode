package _0601_0650._616_Add_Bold_Tag_in_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity: O(len(word) * maxWordLength + s.length() * maxWordLength + s.length())
 * Space complexity: O(len(word) * maxWordLength + s.length())
 * <p>
 * Runtime: 42 ms
 */
public final class TrieSolution implements Solution {
  private static final String BOLD_START = "<b>", BOLD_END = "</b>";
  private final Node root = new Node();

  public String addBoldTag(String s, String[] dict) {
    for (String word : dict) {
      insert(root, word, 0);
    }
    final boolean[] isBold = new boolean[s.length()];
    for (int i = 0; i < s.length(); i++) {
      final int len = search(root, s, i);
      Arrays.fill(isBold, i, i + len, true);
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (isBold[i]) {
        sb.append(BOLD_START).append(s.charAt(i));
        while (i + 1 < s.length() && isBold[i + 1]) {
          sb.append(s.charAt(i + 1));
          i++;
        }
        sb.append(BOLD_END);
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }

  private static int search(final Node root, final String s, final int i) {
    int res = 0;
    if (root.word != null) {
      res = Math.max(res, root.word.length());
    }
    if (i == s.length()) {
      return res;
    }
    final char chr = s.charAt(i);
    if (!root.next.containsKey(chr)) {
      return res;
    }
    return Math.max(res, search(root.next.get(chr), s, i + 1));
  }

  private static void insert(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }

    final char chr = word.charAt(i);
    root.next.putIfAbsent(chr, new Node());
    insert(root.next.get(chr), word, i + 1);
  }

  private static final class Node {
    private String word;
    private final Map<Character, Node> next = new HashMap<>();
  }
}
