package interviews.google._642_Design_Search_Autocomplete_System;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/29/2020
 */
public final class AutocompleteSystemI implements AutocompleteSystem {
  private static final char END = '#', SPACE = ' ';
  private static final int N = 26, MAX = 3;
  private final Node root = new Node();
  private Node cur = null;
  private final StringBuilder sb = new StringBuilder();

  public AutocompleteSystemI(String[] sentences, int[] times) {
    for (int i = 0; i < sentences.length; ++i) {
      add(root, sentences[i], times[i], 0);
    }
    reset();
  }

  private void reset() {
    sb.setLength(0);
    cur = root;
  }

  public List<String> input(char c) {
    if (c == END) {
      add(root, sb.toString(), 1, 0);
      reset();
      return new ArrayList<>();
    }
    final Queue<Node> pq = new PriorityQueue<>((x, y) -> {
      final int countCmp = Integer.compare(x.count, y.count);
      if (countCmp != 0) {
        return countCmp;
      }
      return y.word.compareTo(x.word);
    });
    sb.append(c);
    if (cur == null) {
      return new ArrayList<>();
    }
    cur = cur.next[getCharIndex(c)];
    search(pq, cur);
    final LinkedList<String> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove().word);
    }
    return result;
  }

  private void search(final Queue<Node> pq, final Node cur) {
    if (cur == null) {
      return;
    }
    if (cur.word != null) {
      pq.add(cur);
      if (pq.size() > MAX) {
        pq.remove();
      }
    }
    for (final Node next : cur.next) {
      search(pq, next);
    }
  }

  private static void add(final Node root, final String word, final int toAddTimes, final int index) {
    if (word.length() == index) {
      root.count += toAddTimes;
      root.word = word;
      return;
    }
    final int chrIndex = getCharIndex(word.charAt(index));
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    add(root.next[chrIndex], word, toAddTimes, index + 1);
  }

  private static int getCharIndex(final char chr) {
    if (chr == SPACE) {
      return N;
    }
    return chr - 'a';
  }

  private static final class Node {
    private int count = 0;
    private String word = null;
    private final Node[] next = new Node[N + 1];
  }

}
