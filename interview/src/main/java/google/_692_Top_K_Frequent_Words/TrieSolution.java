package google._692_Top_K_Frequent_Words;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 110 / 110 test cases passed.
 * Status: Accepted
 * Runtime: 22 ms
 *
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
public final class TrieSolution implements Solution {
  private static final int N = 26;
  private static final char BASE = 'a';

  public List<String> topKFrequent(String[] words, int k) {
    final Trie trie = new Trie(words);
    return trie.searchTopK(k);
  }

  private static final class Trie {
    private final TrieNode root = new TrieNode();

    Trie(final String[] words) {
      for (final String word : words) {
        insert(root, word, 0);
      }
    }

    private void insert(final TrieNode root, final String word, final int i) {
      if (i == word.length()) {
        root.word = word;
        root.count++;
        return;
      }
      final char chr = word.charAt(i);
      if (root.next[chr - BASE] == null) {
        root.next[chr - BASE] = new TrieNode();
      }

      insert(root.next[chr - BASE], word, i + 1);
    }

    private List<String> searchTopK(final int k) {
      final Queue<TrieNode> pq = new PriorityQueue<>(new Comparator<TrieNode>() {
        // less frequency up, higher alphabetical up
        @Override
        public int compare(TrieNode o1, TrieNode o2) {
          int cmp = Integer.compare(o1.count, o2.count);
          if (cmp == 0) {
            return o2.word.compareTo(o1.word);
          }
          return cmp;
        }
      });

      search(root, k, pq);

      final LinkedList<String> result = new LinkedList<>();
      while (!pq.isEmpty()) {
        result.addFirst(pq.remove().word);
      }
      return result;
    }

    private void search(TrieNode root, final int k, final Queue<TrieNode> pq) {
      if (root == null) {
        return;
      }
      if (root.count > 0) {
        pq.add(root);
        if (pq.size() > k) {
          pq.remove();
        }
      } // end if

      for (int i = 0; i < N; i++) {
        search(root.next[i], k, pq);
      }
    }
  }


  private static final class TrieNode {
    private String word = null;
    private int count = 0;
    private final TrieNode[] next = new TrieNode[N];
  }
}
