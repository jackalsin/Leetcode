package _0951_1000._959_Regions_Cut_By_Slashes;

public final class UnionFindSolution implements Solution {
  private static final int NORTH = 0,
      WEST = 2, EAST = 3,
      SOUTH = 1;

  public int regionsBySlashes(String[] grid) {
    final int N = grid.length;
    final UnionFind uf = new UnionFind(N);

    for (int row = 0; row < N; row++) {
      for (int col = 0; col < N; col++) {
        final char chr = grid[row].charAt(col);
        if (chr == '\\') {
          uf.union(uf.getIndex(NORTH, row, col), uf.getIndex(EAST, row, col));
          uf.union(uf.getIndex(SOUTH, row, col), uf.getIndex(WEST, row, col));
        } else if (chr == '/') {
          uf.union(uf.getIndex(NORTH, row, col), uf.getIndex(WEST, row, col));
          uf.union(uf.getIndex(SOUTH, row, col), uf.getIndex(EAST, row, col));
        } else {
          assert chr == ' ';
          uf.union(uf.getIndex(NORTH, row, col), uf.getIndex(WEST, row, col));
          uf.union(uf.getIndex(SOUTH, row, col), uf.getIndex(EAST, row, col));
          uf.union(uf.getIndex(SOUTH, row, col), uf.getIndex(NORTH, row, col));
        }
        if (row > 0) {
          uf.union(uf.getIndex(NORTH, row, col), uf.getIndex(SOUTH, (row - 1), col));
        }
        if (row < N - 1) {
          uf.union(uf.getIndex(SOUTH, row, col), uf.getIndex(NORTH, (row + 1), col));
        }
        if (col > 0) {
          uf.union(uf.getIndex(WEST, row, col), uf.getIndex(EAST, row, col - 1));
        }
        if (col < N - 1) {
          uf.union(uf.getIndex(EAST, row, col), uf.getIndex(WEST, row, col + 1));
        }
      }
    }
    return uf.total;
  }

  private static final class UnionFind {
    private final int N;
    private final int[] roots;
    private int total;

    public UnionFind(final int N) {
      this.N = N;
      total = 4 * N * N;
      roots = new int[total];
      for (int i = 0; i < total; i++) {
        roots[i] = i;
      }
    }

    private int getIndex(final int dir, final int row, final int col) {
      return dir * N * N + row * N + col;
    }

    private int root(int p) {
      while (p != roots[p]) {
        p = roots[p];
      }
      return p;
    }

    private void union(int p, int q) {
      final int rootP = root(p), rootQ = root(q);
      if (rootP == rootQ) return;
      roots[rootP] = rootQ;
      total--;
    }
  }
}
