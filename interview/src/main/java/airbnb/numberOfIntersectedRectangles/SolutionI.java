package airbnb.numberOfIntersectedRectangles;

public final class SolutionI implements Solution {

  public int countIntersection(int[][][] rectangles) {
    if (rectangles == null || rectangles.length == 0) {
      return 0;
    }
    final int n = rectangles.length;
    final UnionFind uf = new UnionFind(n);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (isIntersect(rectangles[i], rectangles[j])) {
          uf.union(i, j);
        }
      }
    }

    return uf.individualRoots;
  }

  private boolean isIntersect(final int[][] rect1, final int[][] rect2) {
    return (rect1[0][0] <= rect2[0][0] && rect2[0][0] <= rect1[1][0] ||
        rect1[0][0] <= rect2[0][1] && rect2[0][1] <= rect1[1][0])
        && (rect1[0][1] <= rect2[0][1] && rect2[0][1] <= rect1[1][1] ||
        rect1[0][1] <= rect2[1][1] && rect2[1][1] <= rect1[1][1]
    );
  }

  private static final class UnionFind {
    private final int n;
    private final int[] root;
    private int individualRoots;

    UnionFind(int n) {
      this.n = n;
      individualRoots = n;
      root = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
      }
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q);
      if (rootP != rootQ) {
        root[rootP] = rootQ;
        individualRoots--;
      }
    }

    private int root(int p) {
      while (p != root[p]) {
        p = root[p];
      }
      return p;
    }
  }
}
