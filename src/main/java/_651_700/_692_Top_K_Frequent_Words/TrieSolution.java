package _651_700._692_Top_K_Frequent_Words;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/3/2018.
 */
public class TrieSolution implements Solution {
  private static final char A = 'a';
  private static final int N = 26;
  private final TrieNode root = new TrieNode();

  @Override
  public List<String> topKFrequent(String[] words, int k) {
    for (final String word : words) {
      insert(root, word, 0);
    }

    final Queue<TrieNode> pq = new PriorityQueue<>(new Comparator<TrieNode>() {
      @Override
      public int compare(TrieNode o1, TrieNode o2) {
        int cmp = Integer.compare(o1.count, o2.count);
        if (cmp == 0) {
          return o2.word.compareTo(o1.word);
        }
        return cmp;
      }
    });

    findAll(pq, k, root);
    final LinkedList<String> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove().word);
    }
    return result;
  }

  private void findAll(Queue<TrieNode> pq, int k, TrieNode parent) {
    if (parent == null) {
      return;
    }
    if (parent.count > 0) {
      pq.add(parent);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    for (final TrieNode child : parent.next) {
      findAll(pq, k, child);
    }
  }

  private void insert(final TrieNode root, final String word, int index) {
    if (index == word.length()) {
      root.count++;
      root.word = word;
      return;
    }
    final char chr = word.charAt(index);
    if (root.next[chr - A] == null) {
      root.next[chr - A] = new TrieNode();
    }
    insert(root.next[chr - A], word, index + 1);
  }

  private static final class TrieNode {
    private int count = 0;
    private final TrieNode[] next = new TrieNode[N];
    private String word;
  }

}
