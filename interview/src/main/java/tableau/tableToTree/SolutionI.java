package tableau.tableToTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {

  private final Node root = new Node("");

  public List<String> transform(List<String> input) {
    for (final String line : input) {
      add(root, line.split(" "), 0);
    }
    final List<String> result = new ArrayList<>();
    traverse(result, root, 0);
    return result;
  }

  private void traverse(final List<String> result, final Node root, final int prefixPadding) {
    if (root == null) {
      return;
    }

    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < prefixPadding; ++i) {
      sb.append(" ");
    }
    for (final Map.Entry<String, Node> e : root.next.entrySet()) {
      sb.setLength(prefixPadding);
      final String nextWord = e.getKey();
      sb.append(nextWord);
      result.add(sb.toString());
      traverse(result, e.getValue(), prefixPadding + nextWord.length());
    }
  }

  private static void add(final Node root, final String[] words, int i) {
    if (i == words.length) {
      return;
    }
    final String word = words[i];
    root.next.putIfAbsent(word, new Node(word));
    add(root.next.get(word), words, i + 1);
  }

  private static final class Node {
    private final String word;
    private final Map<String, Node> next = new HashMap<>();

    private Node(String word) {
      this.word = word;
    }
  }
}
