package _1201_1250._1202_Smallest_String_With_Swaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
public final class SolutionI implements Solution {

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    final UnionFind uf = new UnionFind(s.length());
    final List<List<Character>> result = new ArrayList<>();
    for (int i = 0; i < s.length(); ++i) {
      result.add(new ArrayList<>());
    }
    for (final List<Integer> p : pairs) {
      uf.union(p.get(0), p.get(1));
    }
    final int n = s.length();
    for (int i = 0; i < n; ++i) {
      result.get(uf.root(i)).add(s.charAt(i));
    }
    final StringBuilder sb = new StringBuilder();
    result.forEach(x -> x.sort(new Comparator<Character>() {
      @Override
      public int compare(Character o1, Character o2) {
        return Character.compare(o2, o1);
      }
    }));
    for (int i = 0; i < s.length(); ++i) {
      final List<Character> list = result.get(uf.root(i));
      sb.append(list.remove(list.size() - 1));
    }
    return sb.toString();
  }

  private static final class UnionFind {
    private final int[] sizes, roots;

    private UnionFind(int n) {
      sizes = new int[n];
      Arrays.fill(sizes, 1);
      roots = new int[n];
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
    }

    private void union(int p, int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = roots[rootQ];
        sizes[rootQ] += sizes[rootP];
      } else {
        roots[rootQ] = roots[rootP];
        sizes[rootP] += sizes[rootQ];
      }
    }

    private int root(int p) {
      while (p != roots[p]) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }
  }
}
