package google._305_Number_of_Islands_II;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class Solution {
  private static final int[][] DIRS = {
      {1, 0}, {-1, 0}, {0, -1}, {0, 1}
  };

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    UnionFind uf = new UnionFind(m, n);
    final List<Integer> result = new ArrayList<>();
    for (final int[] position : positions) {
      int curPos = uf.getIndex(position);
      uf.addIsland(curPos);
      for (final int[] dir : DIRS) {
        final int[] nextPosition = {position[0] + dir[0], position[1] + dir[1]};
        int nextPos = uf.getIndex(nextPosition);
        if (nextPosition[0] >= 0 && nextPosition[0] < m && nextPosition[1] < n
            && nextPosition[1] >= 0 && uf.root[nextPos] != -1 && !uf.find(curPos, nextPos)) {
          uf.union(curPos, nextPos);
        }
      }
      result.add(uf.realRootCount);
    }
    return result;
  }

  private static final class UnionFind {
    private final int m, n;
    private final int[] root;
    private final int[] size;
    private int realRootCount = 0;

    public UnionFind(int m, int n) {
      this.m = m;
      this.n = n;
      root = new int[m * n];
      size = new int[m * n];
      Arrays.fill(root, -1);
    }

    int getIndex(int[] pos) {
      return pos[0] * n + pos[1];
    }

    void union(int p, int q) {
      int rootP = root(p), rootQ = root(q), sizeP = size[rootP], sizeQ = size[rootQ];
      if (rootP != rootQ) {
        if (sizeP > sizeQ) {
          root[rootQ] = rootP;
          size[rootP] += sizeQ;
        } else {
          root[rootP] = rootQ;
          size[rootQ] += sizeP;
        }
        realRootCount--;
        assert realRootCount >= 0;
      }
    }

    void addIsland(int p) {
      root[p] = p;
      size[p] = 1;
      realRootCount++;
    }

    boolean find(int p, int q) {
      return root(p) == root(q);
    }

    int root(int p) {
      while (root[p] != p) {
        p = root[p];
      }
      return p;
    }
  }
}
