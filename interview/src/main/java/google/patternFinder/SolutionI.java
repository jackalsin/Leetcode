package google.patternFinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
public final class SolutionI implements Solution {
  private final Node root = new Node();
  private static final char SLASH = '/';

  /**
   * Assume all string doesn't have duplicate //
   *
   * @param patterns
   */
  public SolutionI(final String[] patterns) {
    if (patterns == null || patterns.length == 0) return;
    for (int i = 0; i < patterns.length; ++i) {
      add(root, patterns[i], 0, i);
    }
  }

  private void add(final Node root, final String pattern, int i, final int index) {
    assert root != null;
    if (i >= pattern.length()) {
      root.index = index;
      return;
    }
    final char chr = pattern.charAt(i);
    root.next.putIfAbsent(chr, new Node());
    if (pattern.startsWith("/:", i)) {
      root.shouldJumpToNextSlash = true;
      i++;
      while (i < pattern.length()) {
        if (pattern.charAt(i) == SLASH) break;
        i++;
      }
      add(root.next.get(chr), pattern, i + 1, index);
    } else {
      add(root.next.get(chr), pattern, i + 1, index);
    }
  }

  @Override
  public int pattern(String url) {
    return search(root, url, 0);
  }

  private int search(final Node root, final String url, int i) {
    if (root == null) return -1;
    if (i >= url.length()) return root.index;
    if (root.shouldJumpToNextSlash) {
      assert url.charAt(i) == SLASH;
      ++i;
      while (i < url.length()) {
        if (url.charAt(i) == SLASH) break;
        i++;
      }
      return search(root.next.get(SLASH), url, i + 1);
    }
    final char chr = url.charAt(i);
    return search(root.next.get(chr), url, i + 1);
  }

  private static final class Node {
    private int index = -1;
    private boolean shouldJumpToNextSlash = false;
    private final Map<Character, Node> next = new HashMap<>();
  }


}
