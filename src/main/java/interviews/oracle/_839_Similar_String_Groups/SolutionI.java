package interviews.oracle._839_Similar_String_Groups;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 11/9/2019
 */
public final class SolutionI implements Solution {

  public int numSimilarGroups(String[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final int n = A.length;
    final UnionFind uf = new UnionFind(n);
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        if (isSimilar(A[i], A[j])) {
          uf.union(i, j);
        }
      }
    }
    return uf.individualRoots;
  }

  static boolean isSimilar(final String a, final String b) {
    int count = 0;
    for (int i = 0; i < a.length(); ++i) {
      final char aChar = a.charAt(i), bChar = b.charAt(i);
      if (aChar == bChar) continue;
      count++;
      if (count > 2) {
        return false;
      }
    }
    return true;
  }

  private static final class UnionFind {
    private int individualRoots;
    private final int[] sizes, roots;

    private UnionFind(int n) {
      this.individualRoots = n;
      sizes = new int[n];
      roots = new int[n];
      Arrays.fill(sizes, 1);
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (rootQ == rootP) return;
      individualRoots--;
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
