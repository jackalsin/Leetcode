package google.videoPlayList;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class Solution {
  // 第一轮：华人小哥 很明显的一道union find题
  //给定一堆video playlist l1: [1, 2, 4, 5], l2: [2, 4], l3: [6], l4: [5].
  // 求里面有几个cluster。规则：1.拥有相同video 的两个list属于同一cluster； 2. 以上的property可以commute：如果l1,
  // l2属于同一个cluster，l2, l3也属于同一个cluster，那么l1, l2, l3 都在同一cluster里。
  //followup: 如何优化

  public int clusterCount(final int[][] playlists) {
    if (playlists == null || playlists.length == 0) {
      return 0;
    }
    int maxNode = getMax(playlists);
    final UnionFind uf = new UnionFind(maxNode + 1);
    for (final int[] playlist : playlists) {
      if (uf.roots[playlist[0]] == -1) {
        uf.add(playlist[0]);
      }
      for (int i = 1; i < playlist.length; i++) {
        if (uf.roots[playlist[i]] == -1) {
          uf.add(playlist[i]);
        }
        if (!uf.find(playlist[0], playlist[i])) {
          uf.union(playlist[i - 1], playlist[i]);
        }
      }
    }
    return uf.realRootCount;
  }

  private static final class UnionFind {
    /* the size not the max node value*/
    private final int m;
    private final int[] roots;
    private final int[] size;

    int realRootCount = 0;

    UnionFind(int m) {
      this.m = m;
      roots = new int[m];
      size = new int[m];
      Arrays.fill(roots, -1);
    }

    void add(int p) {
      roots[p] = p;
      size[p] = 1;
      realRootCount++;
    }

    void union(int p, int q) {
      assert p < m && q < m;
      final int rootQ = root(q), rootP = root(p), sizeP = size[rootP], sizeQ = size[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        size[rootQ] += sizeP;
      } else {
        roots[rootQ] = rootP;
        size[rootP] += sizeQ;
      }
      realRootCount--;
    }

    boolean find(int p, int q) {
      return root(p) == root(q);
    }

    int root(int p) {
      assert p < m;
      while (roots[p] != p) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }
  }

  private int getMax(int[][] playlists) {
    int max = 0;
    for (final int[] playlist : playlists) {
      for (int video : playlist) {
        max = Math.max(max, video);
      }
    }
    return max;
  }
}
