package _1001_1050._1032_Stream_of_Characters;

import java.util.ArrayList;
import java.util.List;

public final class StreamCheckerI implements StreamChecker {
  private static final int N = 26;
  private final Node root = new Node();
  private static final char BASE = 'a';
  private final List<Character> sb = new ArrayList<>();

  public StreamCheckerI(String[] words) {
    for (String w : words) {
      insert(w);
    }
    root.isWord = false; // eliminate zero length
  }

  private void insert(final String word) {
    Node root = this.root;
    for (int i = word.length() - 1; i >= 0; i--) {
      final char chr = word.charAt(i);
      final int chrIndex = chr - BASE;
      if (root.next[chrIndex] == null) {
        root.next[chrIndex] = new Node();
      }
      root = root.next[chrIndex];
    }
    root.isWord = true;
  }


  public boolean query(char letter) {
    sb.add(letter);
    return query(root, sb);
  }

  private static boolean query(Node root, final List<Character> word) {
    for (int i = word.size() - 1; i >= 0; i--) {
      final char chr = word.get(i);
      final int chrIndex = chr - BASE;
      root = root.next[chrIndex];
      if (root == null) {
        return false;
      }
      if (root.isWord) {
        return true;
      }
    }
    return root.isWord;
  }

  private static final class Node {
    private final Node[] next = new Node[N];
    private boolean isWord;
  }
}
