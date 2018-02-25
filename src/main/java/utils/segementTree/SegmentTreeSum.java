package utils.segementTree;

/**
 * @author jacka
 * @version 1.0 on 9/14/2017.
 */
public final class SegmentTreeSum implements SegmentTree {

  private final int[] segmentTrees;
  private final int n;
  private final int[] values;

  public SegmentTreeSum(final int[] values) {
    n = values.length;
    this.values = values;
    final int height = (int) Math.ceil(Math.log(values.length) / Math.log(2));
    this.segmentTrees = new int[2 * (2 << height) + 1];
    if (n == 0) return;
    constructHelper(values, 0, values.length - 1, 0);
  }

  @Override
  public void update(int i, int val) {
    updateHelper(0, n - 1, i, val - values[i]);
    values[i] = val;
  }

  @Override
  public int get(int rangeStart, int rangeEnd) {
    return getSumRange(rangeStart, rangeEnd, 0, n - 1, 0);
  }

  private int getSumRange(final int queryStart, final int queryEnd, int segmentStart, int segmentEnd,
                          int segmentCur) {
    assert segmentStart <= segmentEnd;
    if (queryStart <= segmentStart && segmentEnd <= queryEnd) {
      return segmentTrees[segmentCur];
    } else if (queryStart > segmentEnd || queryEnd < segmentStart) {
      return 0;
    } else {
      int mid = (segmentEnd - segmentStart) / 2 + segmentStart;
      return getSumRange(queryStart, queryEnd, segmentStart, mid, 2 * segmentCur + 1)
          + getSumRange(queryStart, queryEnd, mid + 1, segmentEnd, 2 * segmentCur + 2);
    }

  }

  private void updateHelper(final int segmentStart, final int segmentEnd,
                            int segmentCur, final int diff) {
    if (segmentCur >= segmentStart && segmentCur <= segmentEnd) {
      segmentTrees[segmentCur] += diff;
      if (segmentStart != segmentEnd) {
        int mid = (segmentEnd - segmentStart) + segmentStart;
        updateHelper(segmentStart, mid, 2 * segmentCur + 1, diff);
        updateHelper(mid + 1, segmentEnd, 2 * segmentCur + 2, diff);
      }
    }
  }

  /**
   * To construct
   *
   * @param values     leaf values
   * @param valStart   start index of leaf values, inclusive
   * @param valEnd     end index of leaf values, inclusive
   * @param segmentCur segmentTree array index
   * @return sum of the array range [start, end
   */
  private int constructHelper(int[] values, int valStart, int valEnd, int segmentCur) {
    if (valStart == valEnd) {
      segmentTrees[segmentCur] = values[valStart];
    } else {
      int mid = (valEnd - valStart) / 2 + valStart;
      segmentTrees[segmentCur] = constructHelper(values, valStart, mid, 2 * segmentCur + 1) +
          constructHelper(values, mid + 1, valEnd, 2 * segmentCur + 2);
    }
    return segmentTrees[segmentCur];
  }
}
