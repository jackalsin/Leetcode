package _0951_1000._990_Satisfiability_of_Equality_Equations;

/**
 * @author jacka
 * @version 1.0 on 10/8/2020
 */
public final class SolutionI implements Solution {
  /**
   * Time Complexity: O(N * 26)
   */
  @Override
  public boolean equationsPossible(String[] equations) {
    final UnionFind uf = new UnionFind();
    for (final String equation : equations) {
      final char[] chars = equation.toCharArray();
      final int p = chars[0] - 'a', q = chars[3] - 'a';
      if (chars[1] == '=') {
        uf.union(p, q);
      }
    }
    for (final String equation : equations) {
      final char[] chars = equation.toCharArray();
      final int p = chars[0] - 'a', q = chars[3] - 'a';
      if (chars[1] == '!') {
        final int rootP = uf.root(p), rootQ = uf.root(q);
        if (rootP == rootQ) {
          return false;
        }
      }
    }
    return true;
  }

  private static final class UnionFind {
    private final int N = 26;
    private final int[] roots = new int[N],
        sizes = new int[N];

    {
      for (int i = 0; i < N; ++i) {
        roots[i] = i;
        sizes[i] = 1;
      }
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizeP;
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizeQ;
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
