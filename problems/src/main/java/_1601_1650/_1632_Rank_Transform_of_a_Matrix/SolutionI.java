package _1601_1650._1632_Rank_Transform_of_a_Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {

  @Override
  public int[][] matrixRankTransform(int[][] matrix) {
    final int rows = matrix.length, cols = matrix[0].length;
    final TreeMap<Integer, List<int[]>> valToPositions = new TreeMap<>();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        valToPositions.computeIfAbsent(matrix[row][col], k -> new ArrayList<>()).add(new int[]{row, col});
      }
    }
    final int[][] result = new int[rows][cols];
    final int[] rank = new int[rows + cols];
    for (var e : valToPositions.entrySet()) {
      final List<int[]> positions = e.getValue();
      UnionFind uf = new UnionFind(rows + cols);
      final int[] prevRank = rank.clone();
      for (final int[] p : positions) {
        final int rootX = uf.root(p[0]), rootY = uf.root(p[1] + rows);
        uf.union(p[0], p[1] + rows);
        prevRank[rootX] = prevRank[rootY] = Math.max(prevRank[rootX], prevRank[rootY]);
      }
      for (final int[] p : positions) {
        assert uf.root(p[0]) >= rows;
        rank[p[0]] = rank[p[1] + rows] = result[p[0]][p[1]] = prevRank[uf.root(p[0])] + 1;
      }
    }
    return result;
  }

  private static final class UnionFind {
    private final int[] roots;

    private UnionFind(int n) {
      this.roots = new int[n];
      int[] sizes = new int[n];
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
        sizes[i] = 1;
      }
    }

    private void union(final int x, final int y) {
      final int rootP = root(x), rootQ = root(y);
      roots[rootP] = rootQ;
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
