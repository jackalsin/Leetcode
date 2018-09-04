package interviews.linkedin.mianjing._692_Top_K_Frequent_Words;

import java.util.*;

public class Solution {

  public List<String> topKFrequent(String[] words, int k) {
    final TrieNode root = new TrieNode();
    for (String word : words) {
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

    searchAll(pq, root, k);

    final LinkedList<String> result = new LinkedList<>();
    while (!pq.isEmpty()) {
      result.addFirst(pq.remove().word);
    }
    return result;

  }

  private static void searchAll(final Queue<TrieNode> pq, final TrieNode root, final int k) {
    if (root.word != null) {
      pq.add(root);
      if (pq.size() > k) {
        pq.remove();
      }
    } // end of root if

    for (TrieNode child : root.next) {
      if (child != null) {
        searchAll(pq, child, k);
      }
    }
  }

  private static void insert(final TrieNode root, final String word, final int i) {
    if (i == word.length()) {
      root.word = word;
      root.count++;
      return;
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new TrieNode();
    }

    insert(root.next[chrIndex], word, i + 1);
  }


  private static final class TrieNode {
    private final TrieNode[] next = new TrieNode[26];
    private String word;
    private int count = 0;
  }

}
