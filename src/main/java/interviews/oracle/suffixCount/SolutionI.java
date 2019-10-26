package interviews.oracle.suffixCount;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
public final class SolutionI implements Solution {
  private static final int N = 26;

  public int suffixCount(String[] words, String suffix) {
    if (words == null || words.length == 0) {
      throw new IllegalArgumentException("words can not be null or empty");
    }
    if (suffix == null || suffix.length() == 0) {
      throw new IllegalArgumentException("Suffix can not be null or empty");
    }
    final Node root = new Node();
    for (final String word : words) {
      add(root, word, 0);
    }
    return search(root, suffix, 0);
  }

  private static int search(final Node root, final String suffix, final int i) {
    if (root == null) {
      return 0;
    }
    if (i == suffix.length()) {
      return root.count;
    }
    final char chr = suffix.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    return search(root.next[chrIndex], suffix, i + 1);
  }

  private static void add(final Node root, final String word, final int i) {
    if (i == word.length()) {
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    root.next[chrIndex].count++;
    add(root.next[chrIndex], word, i + 1);
  }

  private static final class Node {
    private int count = 0;
    private final Node[] next = new Node[N];
  }
}
