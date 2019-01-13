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
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public List<Integer> numIslands2(int rows, int cols, int[][] positions) {
    final UnionFind uf = new UnionFind(rows, cols);
    final List<Integer> result = new ArrayList<>();
    for (int[] p : positions) {
      final int row = p[0], col = p[1], i = uf.getIndex(p[0], p[1]);
      if (uf.sizes[i] == 0) {
        uf.add(i);
      }
      for (final int[] d : DIRS) {
        final int nextRow = row + d[0], nextCol = col + d[1];
        if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols) continue;
        final int otherI = uf.getIndex(nextRow, nextCol);
        if (uf.sizes[otherI] == 0) continue;
        if (uf.root(i) != uf.root(otherI)) {
          uf.union(i, otherI);
        }
      }
      result.add(uf.count);
    }
    return result;
  }

  private static final class UnionFind {
    private final int m, n;
    private final int[] sizes, roots;
    private int count;

    private UnionFind(final int m, final int n) {
      final int size = m * n;
      this.m = m;
      this.n = n;

      sizes = new int[size];
      roots = new int[size];
      for (int i = 0; i < size; i++) {
        roots[i] = i;
      }
      Arrays.fill(roots, -1);
    }

    private void add(int i) {
      roots[i] = i;
      sizes[i] = 1;
      count++;
    }

    private int root(int p) {
      while (p != roots[p]) {
        p = roots[p];
      }
      return p;
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = sizes[rootP],
          sizeQ = sizes[rootQ];
      if (rootP != rootQ) {
        if (sizeP > sizeQ) {
          roots[rootQ] = rootP;
          sizes[rootP] += sizeP;
        } else {
          roots[rootP] = rootQ;
          sizes[rootQ] += sizeQ;
        }
        count--;
      }
    }

    private int getIndex(final int row, final int col) {
      return col + row * n;
    }
  }
}
