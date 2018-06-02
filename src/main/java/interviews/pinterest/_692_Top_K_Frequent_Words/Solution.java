package interviews.pinterest._692_Top_K_Frequent_Words;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    final Node root = new Node();
    for (String word : words) {
      insert(root, word, 0);
    }

    final Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(final Node a, final Node b) {
        int cmp = Integer.compare(a.count, b.count);
        if (cmp == 0) {
          return b.word.compareTo(a.word);
        }
        return cmp;
      }
    });
    search(root, queue, k);
    final LinkedList<String> result = new LinkedList<>();
    while (!queue.isEmpty()) {
      result.addFirst(queue.remove().word);
    }
    return result;
  }

  private static void search(final Node root, final Queue<Node> queue, final int k) {
    assert root != null;
    if (root.word != null) {
      queue.add(root);
      if (queue.size() > k) {
        queue.remove();
      }
    }
    for (int i = 0; i < 26; i++) {
      if (root.next[i] != null) {
        search(root.next[i], queue, k);
      }
    }
  }

  private static void insert(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.word = word;
      root.count++;
      return;
    }

    final char chr = word.charAt(i);
    final int charIndex = chr - 'a';
    if (root.next[charIndex] == null) {
      root.next[charIndex] = new Node();
    }

    insert(root.next[charIndex], word, i + 1);
  }

  private static final class Node {
    private final Node[] next = new Node[26];
    private String word;
    private int count = 0;
  }

}
