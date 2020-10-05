package twoSigma;

import java.util.Arrays;
import java.util.List;

public final class FriendCircles {
  private static final char Y = 'Y';

  public int circles(final List<String> friends) {
    if (friends == null || friends.size() == 0) {
      return 0;
    }
    final int N = friends.size();
    final UnionFind uf = new UnionFind(N);
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (friends.get(i).charAt(j) == Y) {
          uf.union(i, j);
        }
      }
    }
    return uf.individualRoot;
  }

  private static final class UnionFind {
    private final int N;
    private final int[] roots, sizes;
    private int individualRoot;

    public UnionFind(final int N) {
      this.N = N;
      individualRoot = N;
      roots = new int[N];
      for (int i = 0; i < N; i++) {
        roots[i] = i;
      }
      sizes = new int[N];
      Arrays.fill(sizes, 1);
    }

    public int root(int p) {
      while (p != roots[p]) {
        roots[p] = roots[roots[p]]; // path compression
        p = roots[p];
      }
      return p;
    }

    public void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (rootP == rootQ) return;
      individualRoot--;
      if (sizeP > sizeQ) {
        roots[rootQ] = rootP;
        sizes[rootP] += sizeQ;
      } else {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizeP;
      }
    }
  }
}

