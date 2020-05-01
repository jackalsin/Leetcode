package interviews.byteDance._1202_Smallest_String_With_Swaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    final UnionFind uf = new UnionFind(s.length());
    final int n = s.length();
    for (final List<Integer> p : pairs) {
      uf.union(p.get(0), p.get(1));
    }
    final Map<Integer, Queue<Character>> parentToChildren = new HashMap<>();
    final Map<Integer, List<Integer>> parentToIndex = new HashMap<>();
    for (int i = 0; i < s.length(); ++i) {
      final int root = uf.root(i);
      parentToChildren.computeIfAbsent(root, k -> new PriorityQueue<>()).add(s.charAt(i));
      parentToIndex.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
    }
    final char[] chars = new char[n];
    for (var e : parentToChildren.entrySet()) {
      final int root = e.getKey();
      final Queue<Character> pq = e.getValue();
      final List<Integer> index = parentToIndex.get(root);
      for (int i : index) {
        chars[i] = pq.remove();
      }
    }
    return String.valueOf(chars);
  }

  private static final class UnionFind {
    private final int[] roots, sizes;

    private UnionFind(int n) {
      sizes = new int[n];
      roots = new int[n];
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
      Arrays.fill(sizes, 1);
    }

    private int root(int p) {
      while (p != roots[p]) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (rootP == rootQ) return;
      if (sizeP > sizeQ) {
        roots[rootQ] = rootP;
        sizes[sizeP] = sizeQ;
      } else {
        roots[rootP] = rootQ;
        sizes[sizeQ] = sizeP;
      }
    }
  }
}
