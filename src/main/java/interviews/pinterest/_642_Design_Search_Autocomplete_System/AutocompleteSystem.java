package interviews.pinterest._642_Design_Search_Autocomplete_System;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public final class AutocompleteSystem {

  private static final char SPACE = ' ', POUND = '#';
  private static final int N = 27, MAX_SIZE = 3;

  private final Node root = new Node();
  private Node curRoot = root;

  private final StringBuilder sb = new StringBuilder();

  /**
   * Time complexity: O(len(sentences) *  len( sentence.length() ))
   * Space complexity: O(27 ^ len(word length() ) )
   *
   * @param sentences
   * @param times
   */
  public AutocompleteSystem(String[] sentences, int[] times) {
    assert sentences.length == times.length;

    for (int i = 0; i < sentences.length; i++) {
      insert(root, sentences[i], times[i], 0);
    }
  }

  private void insert(final Node root, String s, int diffTime, int i) {
    if (s.length() == i) {
      root.word = s;
      root.count += diffTime;
      return;
    }

    final char chr = s.charAt(i);
    final int chrIndex = chr == SPACE ? 26 : chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], s, diffTime, i + 1);
  }

  /**
   * Time complexity: O(27 ^ N)
   * Space complexity: O(27 ^ len(word length() ) )
   *
   * @param c
   * @return
   */
  public List<String> input(char c) {
    if (c == POUND) {
//      if (curRoot == null) {
//        insert(root, sb.toString(), 1, 0);
//      } else {
      curRoot.word = sb.toString();
      curRoot.count++;
//      }
      sb.setLength(0);
      curRoot = root;
      return new ArrayList<>();
    }
    // don't add pound
    sb.append(c);

    final Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(final Node a, final Node b) {
        final int cmp = Integer.compare(a.count, b.count);
        if (cmp == 0) {
          return b.word.compareTo(a.word);
        }
        return cmp;
      }
    });

    // search
    final int chrIndex = c == SPACE ? 26 : c - 'a';
    if (curRoot.next[chrIndex] == null) {
//      return new ArrayList<>();
      curRoot.next[chrIndex] = new Node();
    }
    curRoot = curRoot.next[chrIndex];
    search(queue, curRoot);

    final LinkedList<String> result = new LinkedList<>();
    while (!queue.isEmpty()) {
      result.addFirst(queue.remove().word);
    }
    return result;
  }

  private void search(final Queue<Node> queue, final Node curRoot) {
    if (curRoot == null) {
      return;
    }

    if (curRoot.word != null) {
      queue.add(curRoot);
      if (queue.size() > MAX_SIZE) {
        queue.remove();
      }
    }

    for (int i = 0; i < N; i++) {
      if (curRoot.next[i] != null) {
        search(queue, curRoot.next[i]);
      }
    }

  }


  private static final class Node {
    private final Node[] next = new Node[N];
    private String word;
    private int count;
  }
}
