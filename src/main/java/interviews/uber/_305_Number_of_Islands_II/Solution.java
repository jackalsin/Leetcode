package interviews.uber._305_Number_of_Islands_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/7/2018.
 */
public class Solution {
  private static final int[][] DIRS = {
      {-1, 0}, {0, 1}, {0, -1}, {1, 0}
  };

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    final List<Integer> result = new ArrayList<>();
    final UnionFind uf = new UnionFind(m, n);
    for (final int[] position : positions) {
      final int curRow = position[0], curCol = position[1], p = uf.getIndex(curRow, curCol);
      uf.addIsland(p);
      for (final int[] dir : DIRS) {
        int nextRow = curRow + dir[0], nextCol = curCol + dir[1], q = uf.getIndex(nextRow, nextCol);
        if (0 <= nextRow && nextRow < m && nextCol >= 0 && nextCol < n && uf.roots[q] != -1 &&
            !uf.find(p, q)) {
          uf.union(p, q);
        }
      }
      result.add(uf.realRootCount);
    }
    return result;
  }

  private static final class UnionFind {
    private final int[] roots, sizes;
    private final int m, n;
    private int realRootCount = 0;

    UnionFind(int m, int n) {
      roots = new int[m * n];
      sizes = new int[m * n];
      this.m = m;
      this.n = n;
      Arrays.fill(roots, -1);
    }

    public void addIsland(int p) {
      roots[p] = p;
      realRootCount++;
    }

    public int getIndex(int row, int col) {
      return row * n + col;
    }

    public int root(int m, int n) {
      int i = getIndex(m, n);
      return root(i);
    }

    public int root(int p) {
      while (roots[p] != p) {
        p = roots[p];
      }
      return p;
    }

    public void union(int p, int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = sizes[p], sizeQ = sizes[q];
      if (sizeP > sizeQ) {
        roots[rootQ] = rootP;
        sizes[rootP] += sizeQ;
      } else {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizeP;
      }
      realRootCount--;
    }

    public boolean find(int p, int q) {
      return root(p) == root(q);
    }
  }
}
