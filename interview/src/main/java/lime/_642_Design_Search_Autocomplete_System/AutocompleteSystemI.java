package lime._642_Design_Search_Autocomplete_System;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 4/9/2021
 */
public final class AutocompleteSystemI implements AutocompleteSystem {
  private static final char END = '#', BLANK = ' ';
  private static final int N = 3;
  private final Node root = new Node();
  private Node cur = root;
  private final StringBuilder sb = new StringBuilder();

  public AutocompleteSystemI(String[] sentences, int[] times) {
    if (sentences == null || times == null) return;
    final int n = sentences.length;
    for (int i = 0; i < n; ++i) {
      insert(root, sentences[i], 0, times[i]);
    }
  }

  public List<String> input(char c) {
    if (c == END) {
      insert(root, sb.toString(), 0);
      reset();
      return Collections.emptyList();
    }
    sb.append(c);
    if (cur == null) {
      return Collections.emptyList();
    }
    final int charIndex = getCharIndex(c);
    if (cur.next[charIndex] == null) {
      cur = cur.next[charIndex];
      return Collections.emptyList();
    }
    cur = cur.next[charIndex];
    final Queue<Node> pq = new PriorityQueue<>((x, y) -> {
      final int countCmp = Integer.compare(x.count, y.count);
      if (countCmp != 0) return countCmp;
      return -x.word.compareTo(y.word);
    });
    search(pq, cur);
    final LinkedList<String> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove().word);
    }
    return result;
  }

  private static void search(final Queue<Node> pq, final Node root) {
    if (root == null) {
      return;
    }
    if (root.word != null) {
      pq.add(root);
      if (pq.size() > N) {
        pq.remove();
      }
    }
    for (final Node next : root.next) {
      search(pq, next);
    }
  }

  private static void insert(final Node root, final String word, final int i, final int count) {
    if (i == word.length()) {
      root.count += count;
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = getCharIndex(chr);
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, i + 1, count);
  }

  private static void insert(final Node root, final String word, final int i) {
    insert(root, word, i, 1);
  }

  private static int getCharIndex(final char chr) {
    return chr == BLANK ? 26 : chr - 'a';
  }

  private void reset() {
    sb.setLength(0);
    cur = root;
  }

  private static final class Node {
    private String word;
    private int count = 0;
    private final Node[] next = new Node[27];
  }
}
