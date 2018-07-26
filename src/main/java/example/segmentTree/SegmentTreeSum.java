package example.segmentTree;

public final class SegmentTreeSum implements SegmentTree {
  private final int[] values;
  private final int[] segmentTree;
  private final int n;

  public SegmentTreeSum(final int[] values) {
    n = values.length;
    this.values = new int[values.length];
    System.arraycopy(values, 0, this.values, 0, n);

    final int h = (int) Math.ceil(Math.log(n) / Math.log(2));
    this.segmentTree = new int[(2 << h) + 1];

    for (int i = 0; i < values.length; i++) {
      updateHelper(0, n - 1, 0, i, values[i]);
    }
  }


  @Override
  public void update(int i, int val) {
    updateHelper(0, n - 1, 0, i, val - values[i]);
    values[i] = val;
  }

  private void updateHelper(final int ss, final int se, final int sc, final int i, final int diff) {
    if (ss > i || se < i) {
      return;
    }

    segmentTree[sc] += diff;
    if (ss == se) {
      return;
    }
    final int mid = ss + (se - ss) / 2;
    updateHelper(ss, mid, 2 * sc + 1, i, diff);
    updateHelper(mid + 1, se, 2 * sc + 2, i, diff);

  }

  @Override
  public int get(int qs, int qe) {
    return getHelper(0, n - 1, 0, qs, qe);
  }

  private int getHelper(int ss, int se, int sc, int qs, int qe) {
    if (ss > qe || se < qs) {
      return 0;
    } else if (qs <= ss && se <= qe) {
      return segmentTree[sc];
    } else {
      final int mid = ss + (se - ss) / 2;

      return getHelper(ss, mid, sc * 2 + 1, qs, qe)
          + getHelper(mid + 1, se, sc * 2 + 2, qs, qe);
    }
  }
}
