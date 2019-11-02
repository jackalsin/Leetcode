package _0801_0850._839_Similar_String_Groups;

public final class SolutionI implements Solution {
  @Override
  public int numSimilarGroups(String[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final UnionFind uf = new UnionFind(A.length);
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        if (isSimilar(A[i], A[j])) {
          uf.union(i, j);
        }
      }
    }
    return uf.individualRoots;
  }

  static boolean isSimilar(final String a, final String b) {
    assert a != null && b != null && a.length() == b.length();
    final char[] firstDiffChar = new char[2];
    int firstDiffIndex = -1;
    boolean hasMismatch = false;
    for (int i = 0; i < a.length(); ++i) {
      final char aChar = a.charAt(i), bChar = b.charAt(i);
      if (aChar == bChar) continue;
      if (firstDiffIndex == -1) {
        firstDiffChar[0] = aChar;
        firstDiffChar[1] = bChar;
        firstDiffIndex = i;
      } else {
        if (hasMismatch || bChar != firstDiffChar[0] || aChar != firstDiffChar[1]) {
          return false;
        }
        hasMismatch = true;
      }
    }
    return true;
  }

  private static final class UnionFind {
    private final int[] roots, sizes;
    private int individualRoots;

    private UnionFind(final int n) {
      this.individualRoots = n;
      roots = new int[n];
      sizes = new int[n];
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
        sizes[i] = 1;
      }
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (rootP == rootQ) return;
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
