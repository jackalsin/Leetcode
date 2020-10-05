package google._1032_Stream_of_Characters;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
public final class StreamCheckerI implements StreamChecker {
  private static final int N = 26;
  private final Node root = new Node();
  final StringBuilder sb = new StringBuilder();

  public StreamCheckerI(final String[] words) {
    for (final String word : words) {
      add(root, word, word.length() - 1);
    }
  }

  private void add(final Node root, final String word, final int i) {
    if (i == -1) {
      root.isWord = true;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    add(root.next[chrIndex], word, i - 1);
  }

  public boolean query(char letter) {
    sb.append(letter);
    return query(root, sb, sb.length() - 1);
  }

  private static boolean query(final Node root, final StringBuilder sb, final int i) {
    if (root == null) {
      return false;
    }
    if (root.isWord) {
      return true;
    }
    if (i < 0) {
      return false;
    }
    final char chr = sb.charAt(i);
    final int chrIndex = chr - 'a';
    return query(root.next[chrIndex], sb, i - 1);
  }

  private static final class Node {
    private final Node[] next = new Node[N];
    private boolean isWord;
  }
}
