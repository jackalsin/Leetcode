package uber.codeSignal.fangziLianPai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> getMaxUnion(int[] input) {
    if (input == null || input.length == 0) {
      return Collections.emptyList();
    }
    final int max = Arrays.stream(input).max().getAsInt();
    final List<Integer> result = new ArrayList<>();
    final UnionFind uf = new UnionFind(max + 1);
    for (int i = 0; i < input.length - 1; ++i) {
      uf.union(input[i], input[i + 1]);
      result.add(uf.maxSize);
    }
    return result;
  }

  private static final class UnionFind {
    private final int[] roots, sizes;
    private int maxSize = 1;

    private UnionFind(final int n) {
      this.roots = new int[n];
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
      this.sizes = new int[n];
      Arrays.fill(sizes, 1);
    }

    public int root(int p) {
      while (p != roots[p]) {
        p = roots[p];
        roots[p] = roots[roots[p]];
      }
      return p;
    }

    public void union(final int p, final int q) {
      final int rootP = roots[p], rootQ = roots[q],
          sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizeP;
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizeQ;
      }
      maxSize = Math.max(maxSize, sizeP + sizeQ);
    }
  }
}
