package _0301_0350._305_Number_of_Islands_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public class Solution {
  private static final int[][] DIRS = {{1, 0},{0, 1}, {-1, 0}, {0, -1}};
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> result = new ArrayList<>();
    UnionFind uf = new UnionFind(m, n);
    for(int[] position : positions) {
      final int row = position[0], col = position[1];
      uf.add(row, col);
      final int p = uf.getIndex(row, col);
      for(int[] dir: DIRS) {
        final int newRow = position[0] + dir[0], newCol = position[1] + dir[1],
            q = uf.getIndex(newRow, newCol);
        if (uf.isInRange(newRow, newCol) && uf.roots[q] != -1 &&
            !uf.find(p, q)) {
          uf.union(p, q);
        }
      }
      result.add(uf.realRootCount);
    }
    return result;
  }

  private static final class UnionFind {
    final int rows, cols;
    final int[] roots;
    final int[] size;
    int realRootCount = 0;
    UnionFind(int x, int y) {
      this.rows = x;
      this.cols = y;
      roots = new int[rows * cols];
      size = new int[rows * cols];
      Arrays.fill(roots, -1);
    }

    void union(int p, int q) {
      int rootP = root(p), rootQ = root(q);
      if (size[rootP] >= size[rootQ]) {
        roots[rootP] = rootQ;
        size[rootQ] += size[rootP];
      } else {
        roots[rootQ] = rootP;
        size[rootP] += size[rootQ];
      }
      realRootCount--;
    }

    void add(int row, int col) {
      int index = getIndex(row, col);
      roots[index] = index;
      size[index] = 1;
      realRootCount++;
    }

    int root(int p) {
      while (roots[p] != p) {
        p = roots[p];
      }
      return p;
    }

    private int getIndex(int row, int col) {
      return row * cols + col;
    }

    private boolean isInRange(int row, int col) {
      return 0 <= row && row < rows && 0 <= col && col < cols;
    }

    public boolean find(int p, int q) {
      return root(p) == root(q);
    }
  }

}
