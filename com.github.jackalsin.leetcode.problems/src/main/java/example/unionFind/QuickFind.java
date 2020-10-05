package example.unionFind;

/**
 * @author jacka
 * @version 1.0 on 10/11/2017.
 */
public class QuickFind implements UnionFind {
  /**
   * This store the most roots element of the current node.
   */
  private final int[] roots;
  private int count;

  public QuickFind(final int N) {
    this.roots = new int[N];
    count = N;
    for (int i = 0; i < N; ++i) {
      roots[i] = i;
    }
  }

  @Override
  public void union(int p, int q) {
    int pid = roots[p];
    int qid = roots[q];
    for (int i = 0; i < roots.length; ++i) {
      if (roots[i] == qid) {
        roots[i] = pid;
      }
    }
  }

  @Override
  public boolean connected(int p, int q) {
    validate(p);
    validate(q);
    return roots[p] == roots[q];
  }

  @Override
  public int find(int p) {
    validate(p);
    return roots[p];
  }

  @Override
  public int count() {
    return count;
  }

  private void validate(final int p) {
    if (p < 0 || p >= roots.length) {
      throw new IllegalArgumentException("p = " + p + " should be between 0(inclusive) and " + roots
          .length + "(exclusive).");
    }

  }
}
