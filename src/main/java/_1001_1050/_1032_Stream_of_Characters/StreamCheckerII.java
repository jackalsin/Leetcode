package _1001_1050._1032_Stream_of_Characters;

import java.util.ArrayList;
import java.util.List;

public final class StreamCheckerII implements StreamChecker {
  private static final int N = 26;
  private final Node root = new Node();
  private static final char BASE = 'a';
  private List<Node> nodes = new ArrayList<>();

  public StreamCheckerII(String[] words) {
    for (String w : words) {
      insert(root, w, 0);
    }
    root.isWord = false; // eliminate zero length
  }

  private void insert(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.isWord = true;
      return;
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - BASE;
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, i + 1);
  }

  public boolean query(char letter) {
    nodes.add(root);
    final int chrIndex = letter - BASE;
    final List<Node> newResult = new ArrayList<>();
    boolean ret = false;
    for (final Node root : nodes) {
      if (root.next[chrIndex] != null) {
        ret |= root.next[chrIndex].isWord;
        newResult.add(root.next[chrIndex]);
      }
    }
    nodes = newResult;
    return ret;
  }

  private static final class Node {
    private final Node[] next = new Node[N];
    private boolean isWord;
  }
}
