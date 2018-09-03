package interviews.linkedin.mianjing._305_Number_of_Islands_II;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {-1, 0}, {1, 0}
  };

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    final UnionFind uf = new UnionFind(m, n);
    final List<Integer> result = new ArrayList<>();
    for (int[] pos : positions) {
      final int x = pos[0], y = pos[1], p = uf.getPos(x, y);
//      System.out.println("x = " + x + ", y = " + y);
      uf.roots[p] = p;
      uf.size[p] = 1;
      uf.islands++;
      for (int[] dir : DIRS) {
        final int nextX = x + dir[0], nextY = y + dir[1], q = uf.getPos(nextX, nextY);
        if (nextX < 0 || nextY < 0 || nextX >= m | nextY >= n) {
          continue;
        }
        final int rootQ = uf.root(q), rootP = uf.root(p);
        if (rootQ == -1 || rootP == rootQ) {
          continue;
        }
        uf.union(rootP, rootQ);
      }
      result.add(uf.islands);
    }
    return result;
  }


  private static final class UnionFind {
    private final int m, n;
    private final int[] roots, size;
    private int islands;

    UnionFind(final int m, final int n) {
      this.m = m;
      this.n = n;

      roots = new int[m * n];
      size = new int[m * n];
      Arrays.fill(roots, -1);
    }

    private int getPos(final int row, final int col) {
      return col + row * n;
    }

    private int root(int p) {
      if (roots[p] == -1) {
        return -1;
      }

      while (roots[p] != p) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }

    private void union(int p, int q) {
      final int rootP = root(p), rootQ = root(q), sizeP = size[p], sizeQ = size[q];
      assert rootP != -1 && rootQ != -1;
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        size[rootQ] += sizeP;
      } else {
        roots[rootQ] = rootP;
        size[rootQ] += sizeP;
      }
      islands--;
    } // union

  }
}
