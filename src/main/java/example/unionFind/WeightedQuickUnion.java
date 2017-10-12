package example.unionFind;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/11/2017.
 */
public class WeightedQuickUnion implements UnionFind {
  private final int[] roots;
  private final int[] size;
  private int count;

  public WeightedQuickUnion(final int N) {
    count = N;
    this.roots = new int[N];
    this.size = new int[N];
    Arrays.fill(size, 1);
    for (int i = 0; i < N; ++i) {
      roots[i] = i;
    }
  }

  @Override
  public void union(int p, int q) {
    validate(p);
    validate(q);
    final int rootP = find(p);
    final int rootQ = find(q);

    if (rootP != rootQ) {
      if (size[rootP] < size[rootQ]) {
        roots[rootP] = roots[rootQ];
        size[rootQ] += size[rootP];
      } else {
        roots[rootQ] = roots[rootP];
        size[rootP] += size[rootQ];
      }
    }
  }

  @Override
  public boolean connected(int p, int q) {
    validate(p);
    validate(q);
    return find(p) == find(q);
  }

  @Override
  public int find(int p) {
    while (p != roots[p]) {
      roots[p] = roots[roots[p]];
      p = roots[p];
    }
    return p;
  }

  @Override
  public int count() {
    return count;
  }

  // validate that p is a valid index

  private void validate(int p) {
    int N = roots.length;
    if (p < 0 || p >= N) {
      throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (N - 1));
    }
  }
}
