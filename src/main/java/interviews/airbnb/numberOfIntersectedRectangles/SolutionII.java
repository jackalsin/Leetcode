package interviews.airbnb.numberOfIntersectedRectangles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class SolutionII implements Solution {

  public int countIntersection(int[][][] rectangles) {
    if (rectangles == null || rectangles.length == 0) {
      return 0;
    }
    final int n = rectangles.length;
    final UnionFind uf = new UnionFind(n);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (isIntersect(rectangles[i], rectangles[j])) {
          if (uf.root(i) == uf.root(j)) continue;
          uf.union(i, j);
        }
      }
    }
    final Set<Integer> res = new HashSet<>();
    for (int i = 0; i < n; i++) {
      res.add(uf.root(i));
    }
    return res.size();
  }

  private static boolean isIntersect(final int[][] rect1, int[][] rect2) {
    final int left1 = rect1[0][0], bottom1 = rect1[0][1], right1 = rect1[1][0], top1 = rect1[1][1];
    final int left2 = rect2[0][0], bottom2 = rect2[0][1], right2 = rect2[1][0], top2 = rect2[1][1];

    return ((left1 <= left2 && left2 <= right1) || (left1 <= right2 && right2 <= right1))
        && ((bottom1 <= top2 && top2 <= bottom2) || (bottom1 <= bottom2 && bottom2 <= top1));
  }

  private static final class UnionFind {
    private final int n;
    private final int[] size, roots;

    private UnionFind(int n) {
      this.n = n;
      size = new int[n];
      roots = new int[n];
      Arrays.fill(size, 1);
      for (int i = 0; i < n; i++) {
        roots[i] = i;
      }
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q);
      if (rootP == rootQ) return;
      if (size[rootP] > size[rootQ]) {
        roots[rootQ] = rootP;
        size[rootP] += size[rootQ];
      } else {
        roots[rootP] = rootQ;
        size[rootQ] += size[rootP];
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
