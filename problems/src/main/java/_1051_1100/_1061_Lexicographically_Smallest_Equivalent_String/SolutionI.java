package _1051_1100._1061_Lexicographically_Smallest_Equivalent_String;

/**
 * @author zhixi
 * @version 1.0 on 11/15/2020
 */
public final class SolutionI implements Solution {
  private static final char BASE = 'a';

  public String smallestEquivalentString(String A, String B, String S) {
    final UnionFind uf = new UnionFind();
    for (int i = 0; i < A.length(); i++) {
      final int c1 = A.charAt(i) - BASE, c2 = B.charAt(i) - BASE;
      uf.union(c1, c2);
    }
    final StringBuilder sb = new StringBuilder();
    for (final char chr : S.toCharArray()) {
      sb.append((char) (uf.root(chr - BASE) + BASE));
    }
    return sb.toString();
  }

  private static class UnionFind {
    private static final int N = 26;
    private final int[] roots = new int[N];

    private UnionFind() {
      for (int i = 0; i < N; ++i) {
        roots[i] = i;
      }
    }

    private int root(int p) {
      while (p != roots[p]) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }

    private void union(final int p, final int q) {
      assert p < N && q < N;
      final int rootP = root(p), rootQ = root(q);
      roots[rootQ] = roots[rootP] = Math.min(rootP, rootQ);
    }
  }
}
