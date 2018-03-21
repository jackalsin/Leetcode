package interviews.uber._642_Design_Search_Autocomplete_System;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public final class AutocompleteSystem {
  private static final char SPACE = ' ', POUND = '#', BASE = 'a';
  private static final int N = 27, K = 3;
  private final TrieNode root;
  private final StringBuilder sb = new StringBuilder();
  private TrieNode curNode;

  public AutocompleteSystem(String[] sentences, int[] times) {
    root = new TrieNode();
    curNode = root;
    for (int i = 0; i < sentences.length; i++) {
      final String sentence = sentences[i];
      final int count = times[i];
      insert(root, sentence, count, 0);
    }
  }

  private void insert(final TrieNode root, final String sentence, final int count, final int i) {
    if (sentence.length() == i) {
      root.count += count;
      root.word = sentence;
      return;
    }
    final char chr = sentence.charAt(i);
    final int nextIndex = getIndex(chr);
    if (root.next[nextIndex] == null) {
      root.next[nextIndex] = new TrieNode();
    }
    insert(root.next[nextIndex], sentence, count, i + 1);
  }

  public List<String> input(char c) {
    if (c == POUND) {
      // change to a word end node
      insert(root, sb.toString(), 1, 0);

      sb.setLength(0);
      curNode = root;
      return new ArrayList<>();
    }
    sb.append(c);
    final int index = getIndex(c);
    if (curNode != null) {
      curNode = curNode.next[index];
    }
    return search(curNode);
  }

  private int getIndex(char chr) {
    return chr == SPACE ? 26 : chr - BASE;
  }

  private List<String> search(TrieNode curNode) {
    if (curNode == null) {
      return new ArrayList<>();
    }
    final Queue<TrieNode> queue = new PriorityQueue<>(new Comparator<TrieNode>() {
      @Override
      public int compare(TrieNode t1, TrieNode t2) {
        int cmp = Integer.compare(t1.count, t2.count);
        if (cmp == 0) {
          return t2.word.compareTo(t1.word);
        }
        return cmp;
      }
    });

    search(queue, curNode);
    final List<String> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      result.add(queue.remove().word);
    }
    Collections.reverse(result);
    return result;
  }

  private void search(final Queue<TrieNode> queue, final TrieNode curNode) {
    if (curNode == null) {
      return;
    }
    if (curNode.word != null) {
      queue.add(curNode);
      if (queue.size() > K) {
        queue.remove();
      }
    }

    for (final TrieNode next : curNode.next) {
      if (next != null) {
        search(queue, next);
      }
    }
  }

  private static final class TrieNode {
    private String word;
    private final TrieNode[] next = new TrieNode[N];
    private int count;
  }
}
