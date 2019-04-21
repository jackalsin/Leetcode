package _1001_1050._1032_Stream_of_Characters;

public final class StreamChecker {
  private static final int N = 26;
  private final Node root = new Node();
  private static final char BASE = 'a';
  private final StringBuilder sb = new StringBuilder();

  public StreamChecker(String[] words) {
    for (String w : words) {
      insert(root, w, w.length() - 1);
    }
    root.word = null; // eliminate zero length
  }

  private void insert(final Node root, final String word, final int i) {
    if (i == -1) {
      root.word = word;
      return;
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - BASE;
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, i - 1);
  }


  public boolean query(char letter) {
    sb.append(letter);
    return query(root, sb, sb.length() - 1);
  }

  private static boolean query(final Node root, final StringBuilder sb, final int i) {

    if (root.word != null) {
      return true;
    }
    if (i == -1) {
      return false;
    }
    final char chr = sb.charAt(i);
    final int chrIndex = chr - BASE;
    if (root.next[chrIndex] == null) {
      return false;
    }
    return query(root.next[chrIndex], sb, i - 1);
  }

  private static final class Node {
    private final Node[] next = new Node[N];
    private String word;
  }
}
